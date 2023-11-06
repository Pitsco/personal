---
title: Final Project - Individual
description: Individual Code and Individual Blog
layout: post
courses: {'csa': {'week': 11}}
categories: ['C4.0']
type: tangibles
---

# Individual Code:

## Code contribution to project:
[Big Commit with Javascript](https://github.com/CSA-Tri-1/DADDiJkstra-frontend/commit/9f0839c50ab759228ba573c35cd5d5cb2eeb411e)

Code with comments: 


```java
// This code snippet is written in JavaScript and is meant to be used in a web page

// Adding scroll and resize event listeners to the window
window.addEventListener("scroll", setScrollVar);
window.addEventListener("resize", setScrollVar);

// Define the setScrollVar function
function setScrollVar() {
  // Get a reference to the HTML root element
  const htmlElement = document.documentElement;

  // Calculate the percentage of the screen height that has been scrolled
  const percentOfScreenHeightScrolled =
    htmlElement.scrollTop / htmlElement.clientHeight;

  // Log the calculated percentage (limited to a maximum of 100)
  console.log(Math.min(percentOfScreenHeightScrolled * 100, 100));

  // Set a CSS custom property "--scroll" to the calculated percentage
  htmlElement.style.setProperty(
    "--scroll",
    Math.min(percentOfScreenHeightScrolled * 100, 100)
  );
}

// Call the setScrollVar function immediately to set initial values
setScrollVar();

// Create an IntersectionObserver to observe elements in the DOM
const observer = new IntersectionObserver(entries => {
  for (let i = entries.length - 1; i >= 0; i--) {
    const entry = entries[i];

    // Check if the observed element is intersecting with the viewport
    if (entry.isIntersecting) {
      // Hide all elements with a "data-img" attribute
      document.querySelectorAll("[data-img]").forEach(img => {
        img.classList.remove("show");
      });

      // Show the image specified in the dataset of the observed element
      const img = document.querySelector(entry.target.dataset.imgToShow);
      img?.classList.add("show");

      // Break the loop after showing the first intersecting element
      break;
    }
  }
});

// Observe elements with a "data-img-to-show" attribute
document.querySelectorAll("[data-img-to-show]").forEach(section => {
  observer.observe(section);
});
```


## Github Analytics Review
[Github commits](https://github.com/Pitsco)

### Original Repository

![img](https://media.discordapp.net/attachments/934591169885790290/1170861289564798996/image.png?ex=655a948c&is=65481f8c&hm=848360be36823312e084a93244e31559b850c030d031f67c7215a6af62fb370a&=&width=423&height=425)

### New Repository:
![img](https://media.discordapp.net/attachments/934591169885790290/1170861700975706112/image.png?ex=655a94ef&is=65481fef&hm=934eca6ae5242b2184370a1db38d3ba99866a7235eed6d97bb020c85cb43d448&=&width=425&height=425)

As you can see, I've not been committing as much as my other group members. My part of this was to write an about page with information about how our general code worked. Additionally, I set up the navbar, but that was all CSS and does not really count toward my part with javascript or java. Alex already talked to Mr. Mortensen about our team contributions, and I recognized that I need to step up my game in the next trimesters.

I also have a bad habit of committing in less commits with more code, not little by little with smaller changes. This could be detrimental big commits/changes may not save sometimes, which in the end can cost a lot of time wasted. Although I've not faced that yet, I should be more catious by committing more changes so I don't lose much progress if my commits don't process through.


# Individual Blog:

### Code in blog:

### Usage in blog: 


### CollegeBoard Quiz Notes:

## Trimester 1 Reflection:

### Memories and Learning:
- I have never touched Javascript or Java before, new experience
- PBL learning with matching game, first full on experience with javascript code.

### Accomplishments:
- More collaborative with team, understood my role
- Felt more engaged, spent more time coding than I have done in the past year in AP CSP


### What I can improve on:
- Contributing to more of the main project
- Comitting more with less code > Committing less with more code
- Touching more on backend, rather than just front end
    - Something to do with machine learning in the next 2 tris (Alex's idea)? Sentiment Analysis?
- Still be more engaged, sometimes I'm on my phone when I shouldn't be


