package beans;

import util.GerenciadorArquivo;
import android.graphics.Bitmap;
import android.util.Base64;

public class Message {
	
	private long id;
    private String user;
    private String titulo;
    private String text;
    private Bitmap image;
    private long date;
    private boolean lida;

    public Message() {
    	this.lida = false;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(String image) {
    	byte[] txtBase64 = Base64.decode(image, 0);
        this.image = GerenciadorArquivo.readImage( txtBase64 );
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean getLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	} 
    
}
