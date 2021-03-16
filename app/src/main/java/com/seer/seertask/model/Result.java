package com.seer.seertask.model;

import java.util.Date;
import java.util.List;

public class Result {
    public String section;
    public String subsection;
    public String title;
    public String url;
    public String uri;
    public String byline;
    public String item_type;
    public Date updated_date;
    public Date created_date;
    public Date published_date;
    public String material_type_facet;
    public String kicker;
    public List<String> des_facet;
    public List<String> org_facet;
    public List<Object> per_facet;
    public List<Object> geo_facet;
    public List<Multimedia> multimedia;
    public String short_url;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getPublished_date() {
        return published_date;
    }

    public void setPublished_date(Date published_date) {
        this.published_date = published_date;
    }

    public String getMaterial_type_facet() {
        return material_type_facet;
    }

    public void setMaterial_type_facet(String material_type_facet) {
        this.material_type_facet = material_type_facet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public List<String> getDes_facet() {
        return des_facet;
    }

    public void setDes_facet(List<String> des_facet) {
        this.des_facet = des_facet;
    }

    public List<String> getOrg_facet() {
        return org_facet;
    }

    public void setOrg_facet(List<String> org_facet) {
        this.org_facet = org_facet;
    }

    public List<Object> getPer_facet() {
        return per_facet;
    }

    public void setPer_facet(List<Object> per_facet) {
        this.per_facet = per_facet;
    }

    public List<Object> getGeo_facet() {
        return geo_facet;
    }

    public void setGeo_facet(List<Object> geo_facet) {
        this.geo_facet = geo_facet;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<Multimedia> multimedia) {
        this.multimedia = multimedia;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }
}
