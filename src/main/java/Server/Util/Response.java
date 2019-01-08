package Server.Util;


import Server.LogHandler.LogWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Response {

    private String      reqId;
    private JSONArray   list;
    private JSONObject  message;


    public Response(SessionHandler s) throws Exception {
        this.reqId = s.getRequestId();
        if(s.getList() != null){
            this.list  = s.getList();
            LogWriter.writeInfoFile(reqId, "Response : "+list.toString());
        }else{
            this.message = s.getMessage();
            LogWriter.writeInfoFile(reqId, "Response : "+message.toString());

        }
        UtilMethods.clearData(s);

    }

    public JSONArray getList() {
        return list;
    }

    public void setList(JSONArray list) {
        this.list = list;
    }

    public JSONObject getMessage() {
        return message;
    }

    public void setMessage(JSONObject message) {
        this.message = message;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }


}
