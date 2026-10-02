# Java DNA Sequence Analyzer

A Java desktop application for loading and analyzing DNA sequence data through a graphical user interface.

This project was originally developed as part of my Java coursework in a biotechnology and bioinformatics program and was later reorganized into a cohesive application for my software portfolio.

## Features

- Load DNA sequences from text files
- Display the original sequence
- Generate the reverse sequence
- Generate the DNA complement
- Generate the reverse complement
- Calculate GC content
- Convert DNA sequences to RNA
- Display results through a Java Swing interface

## Technologies

- Java
- Java Swing
- Object-oriented programming
- Event-driven programming
- File I/O

## Project Structure

```text
java-dna-sequence-analyzer/
├── src/
│   ├── DNASequence.java
│   └── DNASequenceAnalyzer.java
├── examples/
│   └── sample_sequence.txt
└── README.md
```

DNASequence.java contains the sequence data and analysis logic.
DNASequenceAnalyzer.java provides the graphical interface, file selection, event handling, and result display.
Running the Application
Clone the repository and navigate to the project directory.


Compile:
```
javac src/DNASequence.java src/DNASequenceAnalyzer.java
```

Run:
```
java -cp src DNASequenceAnalyzer
```

Select Load DNA File and choose a plain-text DNA sequence. An example sequence is available in examples/sample_sequence.txt.

## Background
The original coursework explored Java programming through biological data problems. This version consolidates that work into a small object-oriented desktop application, separating DNA sequence analysis from the user-interface logic.
