package test;

import generated.*;
import generated.Error;
import org.junit.Test;
import org.xml.sax.SAXException;
import src.Sample;

import javax.xml.bind.JAXBException;

public class SampleTest {
    @Test
    public void shouldInstantiateSampleAndValidateSchema() throws JAXBException, SAXException {
        new Sample(notice());
    }

    @Test(expected=JAXBException.class)
    public void shouldThrowJaxbExceptionForIncompleteData() throws JAXBException, SAXException {
        new Sample(new Notice());
    }

    private Notice notice(){
        Notice notice = new Notice();
        notice.setVersion("version");
        notice.setRequest(request());
        notice.setApiKey("api key");
        notice.setNotifier(notifier());
        notice.setError(error());
        notice.setServerEnvironment(serverEnvironment());
        notice.setCurrentUser(currentUser());
        return notice;
    }

    private CurrentUser currentUser() {
        CurrentUser user = new CurrentUser();
        user.setId("id");
        user.setName("name");
        user.setEmail("email");
        user.setUsername("username");
        return user;
    }

    private ServerEnvironment serverEnvironment() {
        ServerEnvironment env = new ServerEnvironment();
        env.setProjectRoot("project root");
        env.setEnvironmentName("env name");
        return env;
    }

    private Error error() {
        Error error = new Error();
        error.setBacktrace(new Backtrace());
        error.setClazz("clazz");
        error.setMessage("message");
        return error;
    }

    private Notifier notifier() {
        Notifier notifier = new Notifier();
        notifier.setName("name");
        notifier.setUrl("url");
        notifier.setVersion("version");
        return notifier;
    }

    private Request request() {
        Request request = new Request();
        request.setUrl("url");
        request.setAction("action");
        request.setComponent("component");
        return request;
    }
}
