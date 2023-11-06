---
layout: post
title: Jekyll in HTML notes
description: Blog about Jekyll in HTML used in our project
categories: ['C4.0']
type: tangibles
courses: {'csa': {'week': 10}}
---

[Reference](https://github.com/CSA-Tri-1/DADDiJkstra-frontend/blob/main/pages/about.html) for Jekyll with HTML in about page

# Information with Jekyll in about page: 

### YAML Front Matter: 
Jekyll uses YAML front matter to define metadata for a page. In the code you provided, the front matter is enclosed in triple dashes (---) at the beginning of the file and includes information such as the layout to use and the title of the page.

```
---
layout: default
title: About
---
```

### Layouts: 
The layout for this page is specified in the front matter as "default." Jekyll allows you to define layouts for your pages, which can include common elements like headers, footers, and styles, and can be reused across multiple pages.

### Linking CSS and JavaScript: 
Jekyll allows you to include external CSS and JavaScript files using HTML link and script elements. In the code, you see references to CSS and JavaScript files in the "assets/css" and "assets/scripts" directories, respectively. The use of {{ site.baseurl }} in the file paths allows Jekyll to generate the correct paths when building the site, taking into account the base URL of your site.

```
<link rel="stylesheet" href="{{ site.baseurl }}/assets/css/about.css" /> <!-- Jekyll with HTML-->
<script src="{{ site.baseurl }}/assets/scripts/about.js" defer></script> <!-- Jekyll with HTML-->
```


### Markdown to HTML Conversion: 
Jekyll can convert markdown content to HTML. While the code provided doesn't include markdown content, it's a common practice to write content in markdown format, which Jekyll processes and converts into HTML when building the site.

### Summary: 
Jekyll is used in this code to structure the HTML page, define metadata, link CSS and JavaScript files, and convert markdown content to HTML. When building a site with Jekyll, it generates the final HTML pages based on these templates and configurations.

