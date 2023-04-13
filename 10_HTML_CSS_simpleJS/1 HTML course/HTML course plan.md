# HTML course: <hr>

<dl>
<dt>0 HTML introduction</dt>
<dt>1 HTML document structure </dt>
<dt>2 HTML what is a tag</dt>
<dt>3 HTML element</dt>
<dt>4 HTML attributes</dt>
<dt>5 HTML headings</dt>
<dt>6 HTML paragraphs</dt>
<dt>7 HTML formatting</dt>
<dt>8 HTML CSS styles</dt>
<dt>9 HTML links</dt>
<dt>10 HTML forms</dt>
<dt>11 HTML images</dt>
<dt>12 HTML head</dt>
<dt>13 HTML meta tag</dt>
<dt>14 HTML favicon</dt>
<dt>15 HTML tables</dt>
<dt>16 HTML lists</dt>
<dt>17 HTML block & inline elements < p>< div> & < span></dt>
<dt>18 HTML iframes</dt>
<dt>19 HTML character entities</dt>
<dt>20 HTML audio & video media elements</dt>
<dt>21 HTML file paths</dt>
<dt>22 HTML semantics</dt>
<dt>23 HTML Style guide</dt>
</dl>

### 0. HTML introduction

HTML (Hypertext Markup Language) is a coding language used to create websites and web pages. It provides the structure and content
for a website, and uses elements and tags to define headings, paragraphs, links, images, forms, tables, and more. HTML is simple
to learn for beginners and does not require any prior coding experience. With the basics of HTML, you can create a basic webpage
that can be displayed on the web.

### 1 HTML document structure

An HTML document has a specific structure that is used to organize the content and elements of a web page. The basic structure of
an HTML document includes the following elements:

* \<!DOCTYPE>: This is the document type declaration, which tells the browser which version of HTML is being used.
* \<html>:This is the main container for the entire HTML document. All other elements of the page are nested within this tag.
* \<head>:This contains meta information about the document, such as the title of the page, which is displayed in the browser's
  title bar or tab. It also contains links to CSS and JavaScript files.
* \<body>: This contains the content of the web page, such as text, images, and links. This is where the majority of the HTML code
  is written.
* \<h1>, \<p>, \<a>, \<img>:These are some examples of common HTML tags that are used to structure the content of the web page\

The structure of an HTML document starts with <!DOCTYPE> declaration, then <html> element which wraps all other elements, including the \<head> and \<body> elements. The \<head>
contains information about the document and the \<body> contains the content that is visible on the web page. It's important to
keep in mind that the structure is hierarchical, meaning that some elements are nested within other elements. For example, a \<p>
tag would be nested within the \<body> element and the \<img> tag would be nested within an \<a>
tag.

### 2. HTML what is a tag

HTML (Hypertext Markup Language)
is the standard language used to create web pages. Basic HTML tags are the building blocks of an HTML document and are used to
structure the content of a webpage. Some common basic HTML tags include:

* \<html>: This is the main container for an HTML document and wraps all other elements on the page.
* \<head>: This contains meta information about the document, such as the title of the page, which is displayed in the browser's
  title bar or tab
* \<body>: This contains the content of the web page, such as text, images, and links.
* \<h1>, \<h2>, \<h3>, etc: These are headings tags, used to create different levels of headings on a web page
* \<p>: This is used to create paragraphs of text
* \<a>: This is the anchor tag, used to create hyperlinks to other web pages or sections within the same page
* \<img>: This is used to insert images into a web page.
* \<div>: This is a container element, used to group other elements together and apply styles to them
* \<ul>, \<li>: These tags are used to create unordered list. There are many more HTML tags available, each with their own
  specific purpose and attributes. These are just some examples of the most commonly used basic HTML tags.

### 3. HTML element

An HTML element is a building block of an HTML document. It is a container for content, and it can have attributes which provide
additional information about the element. Elements are represented by tags, which are enclosed in angle brackets (e.g. <p>). An
example of an HTML element is the <p> element, which is used to create a paragraph of text. The text inside the <p>
tags is the content of the element, and the <p> and </p> tags are the opening and closing tags of the element, respectively.
Elements can be nested inside other elements, creating a hierarchical structure for the document. For example, an <a> element (
used for creating hyperlinks) can be nested inside a <p>
element, indicating that the text inside the <p> element is a hyperlink. HTML elements have opening and closing tags, and the
content of the element is placed in between. Some elements are self-closing, means they don't have closing tag, like <img>
which is used to add image on the web page.

### 4 HTML attributes

HTML attributes are used to provide additional information about an HTML element. They are added to the opening tag of an element,
and are used to define the properties or characteristics of that element. Attributes are made up of a name and a value, separated
by an equal sign. They come in the form of name="value", for example : <img src="image.jpg" alt="image description">
Some common attributes include:
• id: which is used to uniquely identify an element on a web page • class: which is used to group elements together and apply
styles to them • src: which is used to specify the source of an image or other media file • href: which is used to specify the
link destination of a hyperlink • alt: which is used to provide alternative text for an image, to be displayed if the image cannot
be loaded • style: which is used to apply inline styles to an element. Attributes are added to the opening tag of an element and
provide additional information about that element. They are used to define the properties and characteristics of the element.

### 5 HTML headings

HTML headings are used to create different levels of headings on a web page. There are six levels of headings available in HTML,
ranging from <h1> (the most important) to <h6> (the least important). The <h1> tag is typically used for the main heading of a
page, while <h2> is used for subheadings, and so on. Headings are important for providing a clear structure for the content of a
web page and for making it easier for users to find the information they are looking for. They are also commonly used by search
engines to understand the content of a page and to determine its relevance to search queries. Headings are represented by <h1>
through <h6> tags, and the number inside the tag denotes the level of heading. It's important to use them in a proper hierarchy,
meaning that you should start with <h1> and use subheadings accordingly.

### 6 HTML paragraphs

HTML paragraphs are used to create blocks of text in an HTML document. The <p> tag is used to create a paragraph element, and the
text inside the <p> tags is the content of the element. The <p> tag automatically adds a blank line before and after the
paragraph, creating a clear visual separation between paragraphs. Paragraphs are an important way to organize content on a web
page and to make it more readable and easy to understand. They also help break up large blocks of text and make a page more
visually appealing. Additionally, in web development, CSS can be used to control the appearance of paragraphs, such as font size,
font color, and alignment.

### 7 HTML formatting

HTML formatting elements are used to apply formatting to the text and content of an HTML document. Some common formatting elements
include:
•    <b> and <strong>: bold text •    <i> and <em>: italic text •    <u>: underlined text •    <sub> and <sup>:
subscript and superscript text •    <mark>: text with a highlighter effect •    <del>: text with a strikethrough effect
•    <code>: text that represents computer code •    <pre>: preformatted text •    <small>:smaller text These elements are used to
control the presentation of text in web pages, allowing you to make certain words or phrases stand out, indicate code, or indicate
a specific semantic meaning. It's important to note that with the introduction of CSS in web development, many of these elements
are not used as much as they used to be, as the same formatting can be achieved using CSS styles.

8 HTML CSS styles ========================================================================= CSS (Cascading Style Sheets)
is a language that is used to describe the presentation of an HTML document. It allows you to control the layout, colors, fonts,
and other visual elements of a web page. There are several different types of CSS styles that can be applied to HTML elements:
• Inline styles: are used to apply styles directly to a specific HTML element, using the style attribute. For
example, <p style="color: red;">This is a red paragraph.</p>
• Internal stylesheets: are used to define styles for a single HTML document, by using a <style> element within the <head> of the
document. • External stylesheets: are used to define styles for multiple HTML documents, by creating a separate CSS file and
linking to it using the link element within the <head>
of the HTML document. Each of these types of styles have their own advantages, but external stylesheets are considered best
practice as they separate the presentation of a web page from its structure and content, making it easier to maintain and update

9 HTML links ========================================================================= HTML links, also known as hyperlinks, are
used to create clickable links within an HTML document that can lead to other web pages, other parts of the same page, or other
types of files. The <a> tag is used to create a link, and the href attribute is used to specify the destination URL. Links are an
important way to navigate between web pages and to provide additional information to users. They can also be used to open other
types of files, such as PDFs or images, or to send email messages. Additionally, you can use target attribute to indicate where
the linked document is to be loaded - whether in a new window or tab, or in the current frame. You can also use id attribute
and <a> tag to create a link within the same page

10 HTML forms ========================================================================= Form elements in HTML are used to create
interactive forms for web pages. These elements allow users to input data, such as text fields, checkboxes, radio buttons, and
more. Some common form elements include:
•    <form>: This element is used to create a form and is the container for all other form elements. The action attribute
specifies where the form data should be sent to and the method attribute specifies how the form data should be sent, either "get"
or "post". •    <input>: This element is used to create various types of input fields, such as text fields, checkboxes, and radio
buttons. The type attribute is used to specify the type of input field. •    <textarea>:
This element is used to create a multi-line text input field. •    <select>: This element is used to create a drop-down list of
options for the user to select from. •    <option>: This element is used within the <select> element to define the options
available in the drop-down list. •    <label>: This element is used to associate a text label with a form element, making it
easier for users to understand the purpose of the form field. •    <fieldset> : This element is used to group related form
elements together, and it typically contains a <legend> element that provides a brief description of the group •    <button> :
This element is used to create a button that users can click on to submit the form or perform other actions. To create a form in
HTML, you would use the <form> element to create the container for the form, and then add various form elements such as text
fields, checkboxes, and buttons within the <form> element. The <label>
elements are used to provide a brief description of the form fields, and the <button> element is used to create a submit button
that the user can click on to send the form data.

11 HTML images ========================================================================= HTML images are used to embed images into
a webpage. The basic syntax for adding an image in HTML is the "img" tag, which requires a "src" attribute that specifies the URL
of the image file. Additionally, the "alt" attribute can be used to provide a text description of the image for accessibility and
SEO purposes. Images are an important way to add visual content to a web page and to make it more engaging and interesting for
users. Additionally, you can use the width and height attributes to control the size of the image, and style attribute to control
the position or other aspect of the image. You can also use the <figure> and <figcaption> tags to wrap around the image and to add
a caption to it. It's important to note that using images that are optimized for web can improve the page load time and user
experience.

12 HTML head ========================================================================= •    <head>  in an HTML document is used to
provide meta information about the document. It typically contains elements such as the <title>, <meta>
, <link>, and <style> elements. •    <title> is used to specify the title of the document, which is displayed in the browser's
title bar or tab. •    <meta>  is used to provide additional information about the document, such as keywords for search engines,
the author of the document, and the character set used. •    <link>  is used to link to external resources, such as external
stylesheets, and to specify the relationships between the document and other documents, such as linking to a favicon. •    <style>
is used to define styles for the document, and is typically used to define internal stylesheets. •    <head>  is the first element
that appears in an HTML document, and it must be followed by the <body> element. The information contained in the head is not
displayed on the webpage, but it is used by the browser and search engines to understand the contents of the webpage.

13 HTML meta tag ========================================================================= HTML meta tags provide metadata about
the document, such as keywords, descriptions, and character encoding. They are placed in the head of the document and are not
visible on the page. Some commonly used meta tags include:
•    <meta charset="UTF-8">: Specifies the character encoding for the document.
•    <meta name="keywords" content="HTML, tutorial">: Specifies keywords that are relevant to the document.
•    <meta name="description" content="A beginner's guide to HTML">: Provides a brief summary of the document's content.
•    <meta name="viewport" content="width=device-width, initial-scale=1.0">: Specifies the viewport size and zoom level for mobile
devices.

14 HTML favicon ========================================================================= A favicon (short for "
favorites icon") is a small icon that is associated with a website. It is typically displayed in the browser's address bar, next
to the website's URL, and in browser's bookmark or history lists. In HTML, a favicon is typically defined using a <link> element
in the <head> of the HTML document, with the rel attribute set to "shortcut icon" and the href attribute set to the location of
the favicon file. Favicons are typically 16x16 pixels in size and are saved in the ICO file format, but they can also be in PNG,
GIF, or JPEG format. Favicon provides a unique identity to your website and enhances the user experience as it makes it easy to
identify the website when it's bookmarked or opened in multiple tabs. It's also considered a best practice for website
optimization, as it can improve the visibility and credibility of your website.

15 HTML tables ========================================================================= HTML tables are used to display data in a
tabular format, with rows and columns. The <table> element is used to create a table, and the <tr> (table row)
, <th> (table header), and <td> (table data) elements are used to create rows, headers, and data cells, respectively. HTML tables
are widely used for displaying large amount of data, and it can be useful for creating financial reports, sports scores,
scientific data, and many other types of information. Additionally, you can use <thead>, <tbody>
and <tfoot> elements to group the rows inside the table, and use colspan and rowspan attributes to merge cells together. You can
also use <caption> element to add a caption to the table.

16 HTML lists ========================================================================= HTML lists are used to create lists of
items, such as bullet points or numbered lists. There are two types of lists in HTML: unordered lists (bulleted lists) and ordered
lists (numbered lists). The <ul> element is used to create an unordered list, and the <li> element is used to create list items
within the list. The <ol> element is used to create an ordered list, and the <li> element is used to create list items within the
list. HTML lists are useful for creating structured and organized content, and are commonly used in web pages for creating menus,
instructions, and other types of lists. Additionally, <dl> element can be used for creating definition lists, which consist of a
series of terms and associated definitions.

17 HTML block & inline elements <p><div> & <span>
========================================================================= In HTML, elements are classified as either block-level
or inline elements. Block-level elements create a rectangular block on the page, and take up the full width of their parent
container by default. They create a new line before and after themselves, and can contain other block-level and inline elements.
Examples of block-level elements include <div>, <h1>, <p>, and <table>. Inline elements, on the other hand, only take up as much
width as necessary and do not create a new line before or after themselves. They can only contain other inline elements and cannot
contain block-level elements. Examples of inline elements include <span>, <a>, <img>, and <strong>. It's important to note that
the display property can be used to change an element from a block-level to an inline element, or vice versa. For example, if you
set the display property of a <div> to inline, it will behave like an inline element and if you set the display property of
a <span> to block, it will behave like a block-level element. It's also important to note that some elements are inherently
block-level or inline, regardless of the CSS applied to them.

18 HTML character entities ========================================================================= HTML character entities allow
you to display special characters in HTML that would otherwise be interpreted as markup. These entities are represented by a
string of characters that begin with an ampersand (&) and end with a semicolon (;). • For example, the less-than sign (<) is
represented by the entity &lt; or &#60 • the greater-than sign (>) is represented by the entity &gt; or &#62 • The ampersand (&)
is represented by the entity &amp; or &#38 Using these entities in your HTML code allows you to display these special characters
in the browser without them being interpreted as markup.

19 HTML iframes ========================================================================= An HTML <iframe> element, or "
inline frame," is used to embed another HTML document within the current HTML document. It allows you to embed content from
external sources, such as videos, maps, and other web pages, into your own web page. The <iframe> element has a few attributes
that control its behavior, including:
• src attribute : specifies the URL of the external document to be embedded. • width and height attributes : specify the
dimensions of the iframe. • frameborder attribute : specifies whether or not to display a border around the iframe. • name
attribute : specifies a name for the iframe, which can be used for linking or scripting. It's important to note that iframes can
be a security risk, as they can potentially allow an external site to execute code or steal data from your site. To mitigate this
risk, it's important to only embed content from trusted sources, and to use the "sandbox"
attribute to limit the capabilities of the embedded content.

20 HTML audio & video media elements ========================================================================= HTML media
elements, such as <audio> and <video>, are used to embed audio and video content in a webpage. They can be used to play audio and
video files on the web. Some commonly used attributes include:
• src: Specifies the URL of the audio or video file. • controls: Displays the default controls for playing audio and video. •
autoplay: Automatically starts playing the audio or video. • loop: Loops the audio or video. It's also possible to include a
fallback content inside the <audio> or <video> element, in case the browser doesn't support the element or the specified file
format.

21 HTML file paths ========================================================================= In HTML, file paths are used to
specify the location of external resources, such as images, videos, and other documents. There are two types of file paths:
relative and absolute. Relative file paths specify the location of a resource in relation to the current HTML document. For
example, if an image is in the same folder as the HTML document, the file path would be "image.jpg". If the image is in a
subfolder, the file path would be "subfolder/image.jpg". Absolute file paths specify the full URL of a resource, including the
protocol (
e.g. "http" or "https"), the domain name, and the file path. For example, an absolute file path for an image on the same website
would be "http://www.example.com/images/image.jpg". It's important to note that when linking to files on the same website,
relative file paths are generally used because it makes the site more portable and easier to move or change the domain name. On
the other hand, when linking to files on external website, absolute file paths are generally used. In HTML, file paths are used in
various elements such as <img>, <link>
, <script>, <a> and <iframe> elements by using the src and href attributes.

22 HTML semantics ========================================================================= HTML semantics refers to the practice
of using the appropriate HTML elements to describe the meaning or structure of the content on a web page. This means using
elements such as <h1> for headings, <p> for paragraphs, <a> for links, and so on, rather than using generic elements like <div>
or <span> without any clear meaning. Using semantic elements helps search engines understand the content of a page more easily and
improves accessibility for users of assistive technologies. It also makes the HTML code more readable and maintainable. For
example, instead of using a <div> element with a class of "header" to create a header, you should use an <header> element.
Similarly, instead of using a <div>
element with a class of "nav" to create a navigation menu, you should use a <nav> element. HTML5 introduced new semantic elements
that describe the different parts of a web page such as <header>, <nav>, <main>, <article>, <section>, <aside>, <footer> and many
more. These elements provide more accurate and meaningful information about the content of the page to search engines, assistive
technologies, and other automated tools. It's important to note that using semantics does not affect the visual presentation of a
webpage, it's purely a way to give meaning to the content of the web page.

23 HTML Style guide ========================================================================= A HTML style guide is a set of rules
and conventions for writing HTML code that is consistent, maintainable, and easy to read. It can be helpful for teams working on a
project, to ensure that all code is written in a consistent style and that it adheres to best practices. Here are some elements
that can be included in a HTML style guide:
• Indentation: Specifying how many spaces or tabs should be used for indentation and how the code should be formatted. •
Capitalization: Specifying whether elements, attributes, and values should be in uppercase or lowercase. • Naming conventions:
Specifying how elements, classes, and IDs should be named and how they should be used. • Commenting:
Specifying how and when comments should be used in the code. • Accessibility: Specifying how to make sure that the code is
accessible to users with disabilities. • Validation: Specifying how and when to validate the code using a validator tool. •
Document structure: Specifying how to structure the code, for example, the order of the elements, headings, and sections. •
Formatting: Specifying how to format the code, for example, how to handle white space, line breaks, and empty elements. By
following a HTML style guide, teams can ensure that the code they write is consistent, easy to read, and maintainable, helping to
make the development process more efficient.




















