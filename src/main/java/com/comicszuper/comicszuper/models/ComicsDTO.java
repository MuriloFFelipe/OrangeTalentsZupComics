package com.comicszuper.comicszuper.models;

public class ComicsDTO {

	private long id;

	private long comicId;

	private String titulo;

	private String descricao;

	private float preço;

	private String autor;

	private String ISBN;

	private String cpf;

	public ComicsDTO() {

	}

	public ComicsDTO(long id, long comicId, String titulo, String descricao, float preço, String autor, String ISBN,
			String cpf) {
		super();
		this.id = id;
		this.comicId = comicId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.preço = preço;
		this.autor = autor;
		this.ISBN = ISBN;
		this.cpf = cpf;
	}

	public Comics toEntity(Usuario usuario) {
		return new Comics(this.id, this.comicId, this.titulo, this.descricao, this.preço, this.autor, this.ISBN,
				usuario);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getComicId() {
		return comicId;
	}

	public void setComicId(long comicId) {
		this.comicId = comicId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreço() {
		return preço;
	}

	public void setPreço(float preço) {
		this.preço = preço;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + (int) (comicId ^ (comicId >>> 32));
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Float.floatToIntBits(preço);
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComicsDTO other = (ComicsDTO) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (comicId != other.comicId)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(preço) != Float.floatToIntBits(other.preço))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
