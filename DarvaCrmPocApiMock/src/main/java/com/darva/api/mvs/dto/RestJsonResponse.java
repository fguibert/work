
package com.darva.api.mvs.dto;

import java.util.ArrayList;
import java.util.List;


public final class RestJsonResponse {


        private  boolean result;
        private  String msg;
        private  Object data;

        public RestJsonResponse(boolean result, String msg) {
            this.result = result;
            this.msg = msg;
            this.data = null;
        }
        public RestJsonResponse(boolean result, String msg, Object data) {
            this.result = result;
            this.msg = msg;
            this.data=data;
        }

    
		/**
         * @return the result
         */
        public boolean isResult() {
            return result;
        }

        
    
		/**
         * @return the msg
         */
        public String getMsg() {
            return msg;
        }
		public Object getData() {
			return data;
		}
        
        


    

    
}
