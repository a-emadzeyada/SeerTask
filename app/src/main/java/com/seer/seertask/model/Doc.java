package com.seer.seertask.model;

import java.util.Date;
import java.util.List;

public class Doc {
    public String _abstract;
    public String web_url;
    public String snippet;
    public String lead_paragraph;
    public String print_section;
    public String print_page;
    public String source;
    public List<Multimedia> multimedia;
    public Headline headline;
    public List<Keyword> keywords;
    public Date pub_date;
    public String document_type;
    public String news_desk;
    public String section_name;
    public String subsection_name;
    public Byline byline;
    public String type_of_material;
    public String _id;
    public int word_count;
    public String uri;

    public String get_abstract() {
        return _abstract;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLead_paragraph() {
        return lead_paragraph;
    }

    public void setLead_paragraph(String lead_paragraph) {
        this.lead_paragraph = lead_paragraph;
    }

    public String getPrint_section() {
        return print_section;
    }

    public void setPrint_section(String print_section) {
        this.print_section = print_section;
    }

    public String getPrint_page() {
        return print_page;
    }

    public void setPrint_page(String print_page) {
        this.print_page = print_page;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public void setNews_desk(String news_desk) {
        this.news_desk = news_desk;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSubsection_name() {
        return subsection_name;
    }

    public void setSubsection_name(String subsection_name) {
        this.subsection_name = subsection_name;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public String getType_of_material() {
        return type_of_material;
    }

    public void setType_of_material(String type_of_material) {
        this.type_of_material = type_of_material;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getWord_count() {
        return word_count;
    }

    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
