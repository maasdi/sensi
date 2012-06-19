package com.sensi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Index;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 19, 2012
 */
@Entity
@Table(name="corpuses")
public class Corpus {

	@Id
	@GeneratedValue
	@Column(name="corpus_id")
	private Long id;
	
	@Column(nullable=false, length=255, name="text")
	@Size(max=255, min=1)
	@Index(name="corpuses_text_idx")
	private String text;
	
	@Column(nullable=false, length=30)
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Corpus other = (Corpus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
