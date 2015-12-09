package model.sharepoint;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "reasonOrSDNDefect", "phase", "deltaNumber", "statusValue" })
public class Properties {

	String reasonOrSDNDefect;
	String phase;
	String deltaNumber;
	String statusValue;

	@XmlElement(name="d:ReasonOrSDNDefect")
	public String getReasonOrSDNDefect() {
		return reasonOrSDNDefect;
	}

	public void setReasonOrSDNDefect(String reasonOrSDNDefect) {
		this.reasonOrSDNDefect = reasonOrSDNDefect;
	}

	@XmlElement(name="d:Phase")
	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	@XmlElement(name="d:DeltaNumber")
	public String getDeltaNumber() {
		return deltaNumber;
	}

	public void setDeltaNumber(String deltaNumber) {
		this.deltaNumber = deltaNumber;
	}

	@XmlElement(name="d:StatusValue")
	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

}
