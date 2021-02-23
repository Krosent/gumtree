# GumTree

## Status

![Build and Test GumTree](https://github.com/GumTreeDiff/gumtree/workflows/Build,%20Test%20and%20Deploy%20GumTree/badge.svg?branch=main)

## Description

GumTree is a complete framework to deal with source code as trees and compute differences between them. It includes possibilities such as:
* converting a source file into a language-agnostic tree format
* export the produced trees in various formats
* compute the differences between the trees
* export these differences in various formats
* visualize these differences graphically

Compared to classical code differencing tools, it has two important particularities:
* it works on a tree structure rather than a text structure,
* it can detect moved or renamed elements in addition of deleted and inserted elements.

## Documentation

To use GumTree, you can start by consulting the [Getting Started](https://github.com/GumTreeDiff/gumtree/wiki/Getting-Started) page from our [wiki](https://github.com/GumTreeDiff/gumtree/wiki).

## Screenshots

### The directory diff viewer

![Directory comparator view](https://github.com/GumTreeDiff/gumtree/raw/main/doc/screenshots/screenshot-0.png)

### The file diff viewer

![Diff view](https://github.com/GumTreeDiff/gumtree/raw/main/doc/screenshots/screenshot-1.png)

## Supported languages

We already deal with a wide range of languages: C, Java, JavaScript, Python, R, Ruby. Click [here](https://github.com/GumTreeDiff/gumtree/wiki/Languages) for more details about the language we support.

More languages are coming soon, if you want to help contact [me](http://www.labri.fr/perso/falleri).

## TreeSitter Support
Our job was to add TreeSitter support for Gumtree. We use it explicitly for Java language. 
However, with few tweaks you can ad support for other languages that supported by Tree Sitter. 

TreeSitter Java parsed tree generator is available here: https://github.com/Krosent/GumtreeJavaLangXmlGenerator.

## Original Project
This is a forked Gumtree project. Please look at the original project at https://github.com/GumTreeDiff/gumtree. 

## Referencing
Please always indicate that this repository is based on original work. 
Original project is made by:
```
@inproceedings{DBLP:conf/kbse/FalleriMBMM14,
  author    = {Jean{-}R{\'{e}}my Falleri and
               Flor{\'{e}}al Morandat and
               Xavier Blanc and
               Matias Martinez and
               Martin Monperrus},
  title     = {Fine-grained and accurate source code differencing},
  booktitle = {{ACM/IEEE} International Conference on Automated Software Engineering,
               {ASE} '14, Vasteras, Sweden - September 15 - 19, 2014},
  pages     = {313--324},
  year      = {2014},
  url       = {http://doi.acm.org/10.1145/2642937.2642982},
  doi       = {10.1145/2642937.2642982}
}
```
