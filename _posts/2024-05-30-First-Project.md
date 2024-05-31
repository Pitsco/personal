---
title: Favorite Project 1
description: None
layout: post
courses: {'csa': {'week': 25}}
categories: ['C4.0']
type: tangibles
comments: True
---

# [Research Paper](https://docs.google.com/document/d/1_575a5hAQGO-7pBOH6bUVmYaq5ABJVvQB9EGZTaP06M/edit?usp=sharing)

### [Hugging Face Yelp Dataset](https://huggingface.co/datasets/yelp_review_full)

``` cs
# Install required libraries
!pip install transformers -U
!pip install transformers[torch]
!pip install accelerate>=0.20.1 -U
!pip install datasets
!pip install evaluate

# Import necessary libraries
import torch
from datasets import load_dataset

# Load dataset
dataset = load_dataset("yelp_review_full")

# Access a sample from the dataset (optional)
dataset["train"][50000]

# Tokenization
from transformers import AutoTokenizer
tokenizer = AutoTokenizer.from_pretrained("bert-base-cased")

# Tokenization function
def tokenize_function(examples):
    return tokenizer(examples["text"], padding="max_length", truncation=True)

# Apply tokenization to the dataset
tokenized_datasets = dataset.map(tokenize_function, batched=True)

# Create small training and evaluation datasets
small_train_dataset = tokenized_datasets["train"].shuffle(seed=42).select(range(25000))
small_eval_dataset = tokenized_datasets["test"].shuffle(seed=42).select(range(25000))

# Initialize the model for sequence classification
from transformers import AutoModelForSequenceClassification
model = AutoModelForSequenceClassification.from_pretrained("bert-base-cased", num_labels=5)

# Configure training arguments
from transformers import TrainingArguments, Trainer
training_args = TrainingArguments(output_dir="test_trainer", evaluation_strategy="epoch", num_train_epochs=3)

# Import necessary modules for metric computation
import numpy as np
import evaluate

# Load the desired metric (e.g., accuracy)
metric = evaluate.load("accuracy")

# Define function to compute evaluation metrics
def compute_metrics(eval_pred):
    logits, labels = eval_pred
    predictions = np.argmax(logits, axis=-1)
    return metric.compute(predictions=predictions, references=labels)

# Initialize the Trainer with the model, training arguments, datasets, and metric computation function
trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=small_train_dataset,
    eval_dataset=small_eval_dataset,
    compute_metrics=compute_metrics
)

# Start training
trainer.train()
```

## Roberta:
Training Loss: This is the error calculated on the training dataset during each iteration (or epoch) of the training process. It represents how well the model is fitting the training data. The goal during training is to minimize this loss, which means the model is learning to make more accurate predictions on the training set.

Validation Loss: This is the error calculated on a separate validation dataset during each iteration (or epoch) of the training process. The validation dataset is not used for training; it's held out from the training process and used solely for evaluating the model's performance on unseen data. The validation loss provides an estimate of how well the model is generalizing to new, unseen data. If the validation loss starts to increase while the training loss is decreasing, it indicates that the model is overfitting to the training data and may not generalize well to new data.

### Unsuccessful:
![image](https://github.com/Pitsco/personal/assets/89278326/ec6ce49c-f4c6-4d10-b4e3-0788e674280e)

### Sucessful:
![image](https://github.com/Pitsco/personal/assets/89278326/f8a09af5-4b58-4566-a11b-ab0cea0ff15f)

## Training Graphs (For Comparison):
![image](https://github.com/Pitsco/personal/assets/89278326/9e8b4d48-2b09-435f-a888-8bba5dfd93b5)

# Additions To Project:
### Creating a System: 
- One of the project requirements is to create a system that tracks students' pathways through computer science and provides recommendations. 
- Understanding sentiment analysis techniques can be valuable in developing algorithms to analyze student feedback or sentiment towards different courses or pathways.

### Technology Utilization: 
- The paper explores the use of BERT models, which are based on transformer architectures, for sentiment analysis. 
- This aligns with the requirement to utilize technologies like ML and AI in the project.

### Analysis and Evaluation: 
- The paper presents results from experiments comparing the performance of different BERT models. 
- This demonstrates the ability to analyze and evaluate different approaches or models, which is crucial for determining the effectiveness of the tracking system and other components of the project.


