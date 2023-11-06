---
title: Javascript Code Notes
description: Code in About page for scrolling feature, understanding DOM.
layout: post
courses: {'csa': {'week': 9}}
categories: ['C4.0']
type: tangibles
---

# Notes:

```
const observer = new IntersectionObserver(entries => { ... });
```

This line creates an IntersectionObserver object. An IntersectionObserver is a JavaScript API that allows you to observe when specified elements in the DOM intersect with the viewport or another target element. It takes a callback function as an argument, which will be executed whenever an observed element's intersection state changes.

```
for (let i = entries.length - 1; i >= 0; i--) { ... }
```

This loop iterates through the array of entries passed to the observer's callback function. entries is an array of IntersectionObserverEntry objects, which represent the elements being observed and their intersection status with the viewport.

```
const entry = entries[i];
``` 

Inside the loop, it retrieves the current IntersectionObserverEntry object.

```
if (entry.isIntersecting) { ... }
```

It checks if the observed element is currently intersecting with the viewport. If it is, the code inside this block will execute.

```
document.querySelectorAll("[data-img]").forEach(img => { img.classList.remove("show"); });
```

This line hides all elements with a data-img attribute by removing the "show" class from them. This effectively hides all images that were previously shown.

```
const img = document.querySelector(entry.target.dataset.imgToShow); img?.classList.add("show");
``` 

It selects the image specified in the data-imgToShow attribute of the observed element (entry.target). It then adds the "show" class to this image, making it visible.

```
break;
``` 

After showing the first intersecting element, it breaks out of the loop. This ensures that only the first intersecting element triggers the image visibility changes.

Finally, the code observes elements with a 
```
data-img-to-show attribute using document.querySelectorAll("[data-img-to-show]").forEach(section => { observer.observe(section); });
```

It finds all elements in the DOM with a data-img-to-show attribute and adds them to the IntersectionObserver for monitoring. When any of these elements intersect with the viewport, the callback function (defined at the beginning) will be executed, and it will hide other images and display the specified image.
