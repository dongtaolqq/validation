package test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import com.alipay.model.Person;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestValidation extends AbstractJUnit4SpringContextTests {

    @Autowired
    private Validator             validator;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidate() {
        Person person = new Person("");
        person.setType("2");
        person.setCount(8);

        BindingResult bindingResult = new BeanPropertyBindingResult(person, "p");
        validator.validate(person, bindingResult);

        FieldError fieldError = null;
        if (bindingResult.hasErrors()) {
            for (Object obj : bindingResult.getFieldErrors()) {
                fieldError = (FieldError) obj;
                System.out.println(messageSourceAccessor.getMessage(fieldError.getCode(),
                    fieldError.getArguments()));
            }
        }
    }
}
