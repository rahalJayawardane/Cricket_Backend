package Server.Util;


public class ResData {

    private String      reqId;
    private Response message;


    public ResData(Response data) throws Exception {
        this.reqId = UtilMethods.getReqId();
        this.message= data;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Response getMessage() {
        return message;
    }

    public void setMessage(Response message) {
        this.message = message;
    }
}
