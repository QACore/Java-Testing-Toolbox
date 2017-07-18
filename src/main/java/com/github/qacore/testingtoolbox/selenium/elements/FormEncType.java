package com.github.qacore.testingtoolbox.selenium.elements;

/**
 * The formenctype attribute specifies how form-data should be encoded before sending it to a server. This attribute overrides the form's enctype attribute.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see <a href="https://www.w3.org/TR/2011/WD-html5-20110525/association-of-controls-and-forms.html#attr-fs-formenctype">https://www.w3.org/TR/2011/WD-html5-20110525/association-of-controls-and-forms.html#attr-fs-formenctype</a>
 *
 * @since 1.5.0
 *
 */
public enum FormEncType {

    /**
     * Default. All characters will be encoded before sent.
     */
    APPLICATION_X_WWW_FORM_ENCODED,

    /**
     * No characters are encoded (use this when you are using forms that have a file upload control).
     */
    MULTIPART_FORM_DATA,

    /**
     * Spaces are converted to "+" symbols, but no characters are encoded.
     */
    TEXT_PLAIN;

}
