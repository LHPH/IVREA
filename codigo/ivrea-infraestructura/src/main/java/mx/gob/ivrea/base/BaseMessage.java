package mx.gob.ivrea.base;


public class BaseMessage extends BaseModel{

    private static final long serialVersionUID = 18987857645778L;

    private String mensaje;

    public BaseMessage(){}

    public BaseMessage(String texto){
        this.mensaje = texto;
    }

    public void setMensaje(String texto){
        this.mensaje = texto;
    }

    public String getMensaje(){
        return this.mensaje;
    }
}