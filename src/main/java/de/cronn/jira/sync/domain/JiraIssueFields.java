package de.cronn.jira.sync.domain;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JiraIssueFields extends JiraResource {

	private static final long serialVersionUID = 2L;

	private JiraProject project;

	private String summary;

	private String description;

	private JiraIssueType issuetype;

	private JiraPriority priority;

	private JiraResolution resolution;

	private Set<String> labels;

	private JiraIssueStatus status;

	private Set<JiraVersion> versions;

	private Set<JiraVersion> fixVersions;

	private JiraUser assignee;

	@JsonFormat(pattern = JIRA_DATE_FORMAT)
	private ZonedDateTime updated;

	private JiraComments comment;

	private Map<String, Object> other = new LinkedHashMap<>();

	public JiraIssueFields() {
	}

	public JiraIssueFields(JiraProject project) {
		this.project = project;
	}

	public JiraProject getProject() {
		return project;
	}

	public void setProject(JiraProject project) {
		this.project = project;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public JiraIssueType getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(JiraIssueType issuetype) {
		this.issuetype = issuetype;
	}

	public Set<String> getLabels() {
		return labels;
	}

	public void setLabels(Set<String> labels) {
		this.labels = labels;
	}

	public JiraPriority getPriority() {
		return priority;
	}

	public void setPriority(JiraPriority priority) {
		this.priority = priority;
	}

	public JiraResolution getResolution() {
		return resolution;
	}

	public void setResolution(JiraResolution resolution) {
		this.resolution = resolution;
	}

	public JiraIssueStatus getStatus() {
		return status;
	}

	public void setStatus(JiraIssueStatus status) {
		this.status = status;
	}

	public void setVersions(Set<JiraVersion> versions) {
		this.versions = versions;
	}

	public Set<JiraVersion> getVersions() {
		return versions;
	}

	public void setFixVersions(Set<JiraVersion> fixVersions) {
		this.fixVersions = fixVersions;
	}

	public Set<JiraVersion> getFixVersions() {
		return fixVersions;
	}

	public JiraUser getAssignee() {
		return assignee;
	}

	public void setAssignee(JiraUser assignee) {
		this.assignee = assignee;
	}

	public void setUpdated(ZonedDateTime updated) {
		this.updated = updated;
	}

	public ZonedDateTime getUpdated() {
		return updated;
	}

	public void setComment(JiraComments comment) {
		this.comment = comment;
	}

	public JiraComments getComment() {
		return comment;
	}

	@JsonAnyGetter
	public Map<String, Object> getOther() {
		return other;
	}

	@JsonAnySetter
	public void setOther(String key, Object value) {
		this.other.put(key, value);
	}

	@JsonIgnore
	public JiraComments getOrCreateComment() {
		if (comment == null) {
			comment = new JiraComments();
		}
		return comment;
	}

}
