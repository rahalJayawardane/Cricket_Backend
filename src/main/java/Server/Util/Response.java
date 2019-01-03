package Server.Util;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Response {

    private String      reqId;
    private JSONArray   list;
    private JSONObject  message;


    public Response(String requestId, JSONArray data) throws Exception {
        this.reqId = requestId;
        this.list  = data;

        LogHandler.writeInfoFile(reqId, "Response : "+list.toString());

    }

    public Response(String requestId, JSONObject data) throws Exception {
        this.reqId = requestId;
        this.message= data;

        LogHandler.writeInfoFile(reqId, "Response : "+message.toString());
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
