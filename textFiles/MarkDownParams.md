# Markdown CheatSheet:
<hr>

End of line is  
double space and Enter OR\
use \ + Enter

empty line
<br/>
<br/>
empty line
<hr>

+ Type `&nbsp;` to add a single space.
+ Type `&ensp;` to add 2 spaces.
+ Type `&emsp;` to add 4 spaces.

## Headings:

# Heading1

## Heading2

### Heading3

#### Heading4

##### Heading5

###### Heading6

Alternative heading1
=====

Alternative heading2
------  
<hr>

## Emphasis:

Selected with `backwards apostrophe`\
Italics, with *asterisks* or _underscores_\
Strong / bold, with **asterisks** or __underscores__\
Combined with **asterisks and _underscores_**\
Combined with __asterisks and _underscores___\
Strikethrough uses two tildes. ~~Scratch this.~~\
Underline should be in `<u>` tag<u>text</u>
<hr>

## Lists:

1. First option
2. Second option
    * First sub point
        * First sub sub point
    * Second sub point

    + Third sub point
3. Actual numbers doesn't matter

* Unordered list can use asterisks
    * Unordered list can use asterisks

- Or minuses

+ Or pluses

<hr>

## Links:

[Internal links for Headers](#markdown-cheatsheet)

[comment]: <> (doesnt work in IntellijIdea for now)

[I'm an inline-style link](https://www.google.com)

[I'm an inline-style link with title](https://www.google.com "Google's Homepage")

[I'm a reference-style link][Arbitrary case-insensitive reference text]

[I'm a relative reference to a repository file](ImportantInfo.txt)

[You can use numbers for reference-style link definitions][1]

Or leave it empty and use the [link text itself].

URLs and URLs in angle brackets will automatically get turned into links.
http://www.example.com or <http://www.example.com>

[arbitrary case-insensitive reference text]: https://www.google.com

[1]: https://www.google.com

[link text itself]: https://www.google.com
<hr>

## Images

Inline-style:
![alt text](../10_HTML_CSS_simpleJS/zAssets/images/animals/favicon.png)

Use < img > HTML tag\
<img src="https://images.unsplash.com/photo-1611915387288-fd8d2f5f928b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8&w=1000&q=80" alt= “none” width="100" height="">

Reference-style:
![alt text][logo]

[logo]: ../10_HTML_CSS_simpleJS/zAssets/images/animals/favicon.png
<hr>

## Code and Syntax highlighting

```javascript
var s = "JavaScript syntax highlighting";
alert(s);
```

```java
class HelloWorld {
    public static void main(String[] args) {
        System.our.println('Hello World');
    }
}
```

```
No language indicated, so no syntax highlighting. 
But let's throw in a <b>tag</b>.
```

<hr>

## Tables

Colons can be used to align columns.

| Tables        | Are           | Cool  |
|:--------------|:-------------:| :-----|
| col 1 is long | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| col 3 is      | left-aligned  |    $1 |

There must be at least 3 dashes separating each header cell. The outer pipes (|) are optional, and you don't need to make the raw
Markdown line up prettily. You can also use inline Markdown.

Markdown | Less | Pretty | Another
--- | --- | --- | ---
*Still* | `renders` | **nicely**
1 | 2 | 3

<hr>

## Blockquotes

> This is a very long line that will still be quoted properly when it wraps. Oh boy let's keep writing to make sure this is long enough to actually wrap for everyone. Oh, you can *put* **Markdown** into a blockquote.
<hr>

<dl>
  <dt>Definition list</dt>
  <dd>Is something people use sometimes.</dd>

  <dt>Markdown in HTML</dt>
  <dd>Does *not* work **very** well. Use HTML <em>tags</em>.</dd>
</dl>

## Horizontal rules

Three or more...

---
Hyphens
***
Asterisks
___
Underscores
<hr>
HTML Tag


Here are a few examples of backslash escapes:

\*not emphasis*
\`not an inline code span`
1\. not an ordered list \* not an unordered list \# not a heading

\This is not a backslash escape - the escaped character is not a markup character.






















































































































































































































