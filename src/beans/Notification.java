package beans;

import android.graphics.Bitmap;

/**
*
* @author Rodrigo
*/

public class Notification {

	private long id;
	private String autor;
	private String titulo;
	private String conteudo;
	private Bitmap imagem;
	private boolean lida;

	public Notification(long id, String autor, String titulo, String conteudo,
			 boolean lida) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.lida = lida;
	}

	public boolean getLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Bitmap getImagem() {
		return imagem;
	}

	public void setImagem(Bitmap imagem) {
		//transformar o byte em bitmap aqui
		this.imagem = imagem;
	}

	public String toString() {
		return "Notification{" + "imagem='" + imagem + '\'' + ", titulo='"
				+ titulo + '\'' + '}';
	}

}
