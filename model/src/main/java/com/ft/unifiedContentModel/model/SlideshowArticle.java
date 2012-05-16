package com.ft.unifiedContentModel.model;


public interface SlideshowArticle {
	
	Editorial getEditorial();

	Provenance getProvenance();
	
	Location getLocation();
	
	Master getMaster();

	Packaging getPackaging();

	Body getBody();

	Metadata getMetadata();

    Title getTitle();

    Lifecycle getLifecycle();

}
