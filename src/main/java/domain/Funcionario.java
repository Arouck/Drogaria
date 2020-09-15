package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {
	
	@Column(length = 50, nullable = false)
	private String carteiraDeTrabalho;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDeAdmissao;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public Date getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(Date dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Funcionario [carteiraDeTrabalho=" + carteiraDeTrabalho + ", dataDeAdmissao=" + dataDeAdmissao
				+ ", pessoa=" + pessoa + "]";
	}

}
