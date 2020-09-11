package br.com.sambaTech.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "media")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true, length = 512)
	private String nome;
	@Column(nullable = true, length = 512)
	private String url;
	
	@Column

	private Integer duracao;
	
	@Column(nullable = true)
	private Date dataUpload = new Date();
	
	@Column(nullable = true)
	private Boolean deleted;

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(Integer id, String nome, String url, Integer duracao, Boolean deleted) {
		this.id = id;
		this.nome = nome;
		this.url = url;
		this.duracao = duracao;
		this.dataUpload = new Date();
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", nome=" + nome + ", url=" + url + ", duracao=" + duracao + ", dataUpload="
				+ dataUpload + ", deleted=" + deleted + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(Date dataUpload) {
		this.dataUpload = dataUpload;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
