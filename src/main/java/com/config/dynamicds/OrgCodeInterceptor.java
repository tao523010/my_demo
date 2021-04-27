package com.config.dynamicds;

import com.utils.DataUtils;
import org.apache.http.util.EncodingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class OrgCodeInterceptor implements HandlerInterceptor{
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerInterceptor.class);
	private String orgCodeHeaderName = "orgCode";

	private Set<String> validOrgCodes;

	@Autowired DynamicDatasourceConfigProperties configs;

	public void setOrgCodeHeaderName(String orgCodeName) {
		orgCodeHeaderName = orgCodeName;
	}

	public void setValidOrgCodes(Set<String> validOrgCodes) {
		this.validOrgCodes = validOrgCodes;
	}

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
//    	OrgCodeHolder.putOrgCode("dm");
		getBodyString(httpServletRequest);

		return true;

    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        OrgCodeHolder.remove();
    }

    public String getBodyString(HttpServletRequest httpRequest) {
    	String ss = "";
    	for (String key : httpRequest.getParameterMap().keySet()) {
    		if("documentFacePhoto".equals(key) || "documentOtherPhoto".equals(key) || "filestring".equals(key)) {
				String value = "base64字符串太长不写到日志里了";
				value = new String(EncodingUtils.getBytes(value, "UTF_8"));
				ss += "&"+key+"="+value;
			}else {
				String value = httpRequest.getParameter(key);
				value = new String(EncodingUtils.getBytes(value, "UTF_8"));
				ss += "&"+key+"="+value;
			}
		}
    	return ss.length()>0?ss.substring(1):"";
	 }

    /**
     * 拿到该方法上的checksource注解对象
     */
//    private CheckParam getCheckSource(HandlerMethod handlerMethod) {
//      if (handlerMethod.getBeanType().isAnnotationPresent(CheckParam.class)) {
//        return handlerMethod.getBeanType().getAnnotation(CheckParam.class);
//      } else if (handlerMethod.getMethod().isAnnotationPresent(CheckParam.class)) {
//        return handlerMethod.getMethod().getAnnotation(CheckParam.class);
//      }
//      return null;
//    }

    /**
     * 校验注解配置的属性值
     * @param annotation
     * @param field
     * @param value
     * @param isPositive
     */
//    private boolean checkTypeEnumValue(ValidateType type, String value,String length){
//        if(!type.equals(ValidateType.TYPE_NULL)) {
//        	switch (type){
//            case TYPE_STRING:
//                if(DataUtils.isNullOrEmpty(value.toString())||"null".equals(value.toString().toLowerCase())){
//                    return false;
//                }
//                break;
//            case TYPE_INTEGER:
//                try {
//					Integer.parseInt(value.toString());
//				} catch (Exception e) {
//					// TODO: handle exception
//					return false;
//				}
//                break;
//            case TYPE_DATE:
//	            if(DataUtils.isNullOrEmpty(value.toString())||"null".equals(value.toString().toLowerCase())){
//	                return false;
//	            }else {
//	            	try {
//	            		if(value.length()==10)
//	            			DateUtils.strToDate(value,"yyyy-MM-dd");
//	            		else if(value.length()==19)
//	            			DateUtils.strToDate(value,"yyyy-MM-dd HH:mm:ss");
//	            		else
//	            			return false;
//					} catch (Exception e) {
//						// TODO: handle exception
//						return false;
//					}
//	            }
//	            break;
//        	}
//        }
//        if(length!=null && length.length()>0) {
//        	if(value.length()==Integer.parseInt(length)) {
//        		return false;
//        	}
//        }
//        return true;
//    }

}
