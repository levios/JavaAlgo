## Useful

Java (Assuming ASCII 128)

If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.

Commonly used tables are:

* int[26] for Letters 'a' - 'z' or 'A' - 'Z'
* int[128] for ASCII
* int[256] for Extended ASCII

<p align="right">(<a href="#top">back to top</a>)</p>