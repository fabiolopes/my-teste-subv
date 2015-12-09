package model.sharepoint;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "title", "id", "updated", "link", "content" })
public class Entry {

	String title;
	String id;
	Date updated;
	List<String> link;
	Content content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<String> getLink() {
		return link;
	}

	public void setLink(List<String> link) {
		this.link = link;
	}

    @XmlElement(name="content")
	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

}
