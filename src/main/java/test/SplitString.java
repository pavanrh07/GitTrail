
package test;

import com.tyss.optimize.common.util.CommonConstants;
import com.tyss.optimize.nlp.util.Nlp;
import com.tyss.optimize.nlp.util.NlpException;
import com.tyss.optimize.nlp.util.NlpRequestModel;
import com.tyss.optimize.nlp.util.NlpResponseModel;
import com.tyss.optimize.nlp.util.annotation.InputParam;
import com.tyss.optimize.nlp.util.annotation.InputParams;
import com.tyss.optimize.nlp.util.annotation.ReturnType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class SplitString implements Nlp {
    @InputParams({@InputParam(name = "String", type = "java.lang.String"), @InputParam(name = "RegEx", type = "java.lang.String"), @InputParam(name = "Index", type = "java.lang.Integer")})
    @ReturnType(name = "string3", type = "java.lang.String")

      @Override
      public List<String> getTestParameters() throws NlpException {
        List<String> params = new ArrayList<>();
        return params;
      }

      @Override
      public StringBuilder getTestCode() throws NlpException {
        StringBuilder sb = new StringBuilder();
        return sb;
      }
      @Override
      public NlpResponseModel execute(NlpRequestModel nlpRequestModel) throws NlpException {
        
          NlpResponseModel nlpResponseModel = new NlpResponseModel();
          Map<String, Object> attributes = nlpRequestModel.getAttributes();
          String str = (String) attributes.get("String");
          String RegEx = (String) attributes.get("RegEx");
          int index = (int) attributes.get("Index");
          String returnVal="dummy";

          // Your program element business logic goes here ...
          try {
			String[] strArry = str.split(RegEx); 
			returnVal = strArry[index];
			nlpResponseModel.setStatus(CommonConstants.pass);
			nlpResponseModel.setMessage("Splitted successfully");
		} catch (Exception e) {
			// TODO: handle exception
			nlpResponseModel.setStatus(CommonConstants.fail);
			nlpResponseModel.setMessage(" not Splitted successfully");
		}

          
          nlpResponseModel.getAttributes().put("string3", returnVal);
          return nlpResponseModel;
      }
  } 