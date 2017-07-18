package com.github.qacore.testingtoolbox.selenium.elements;

/**
 * Html button types.
 * 
 * @author Leonardo Carmona da Silva
 *         <ul>
 *         <li><a href="https://br.linkedin.com/in/l3ocarmona">https://br.linkedin.com/in/l3ocarmona</a></li>
 *         <li><a href="https://github.com/leocarmona">https://github.com/leocarmona</a></li>
 *         <li><a href="mailto:lcdesenv@gmail.com">lcdesenv@gmail.com</a></li>
 *         </ul>
 * 
 * @see <a href="https://www.w3.org/TR/2011/WD-html5-20110525/the-button-element.html#attr-button-type">https://www.w3.org/TR/2011/WD-html5-20110525/the-button-element.html#attr-button-type</a>
 * 
 * @since 1.5.0
 *
 */
public enum ButtonType {

    /**
     * The button is a clickable button.
     */
    BUTTON,
    
    /**
     * The button is a submit button (submits form-data).
     */
    SUBMIT,
    
    /**
     * The button is a reset button (resets the form-data to its initial values).
     */
    RESET;

}
