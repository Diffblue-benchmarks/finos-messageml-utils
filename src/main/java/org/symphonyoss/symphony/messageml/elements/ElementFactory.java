package org.symphonyoss.symphony.messageml.elements;

import org.symphonyoss.symphony.messageml.MessageMLContext;
import org.symphonyoss.symphony.messageml.exceptions.InvalidInputException;
import org.symphonyoss.symphony.messageml.exceptions.ProcessingException;
import org.symphonyoss.symphony.messageml.util.DataProvider;
import org.symphonyoss.symphony.messageml.util.IDataProvider;

import java.io.IOException;

public class ElementFactory {
  public static Element makeElement() throws InvalidInputException, IOException, ProcessingException {
    final IDataProvider dataProvider = new DataProvider();

    MessageMLContext context = new MessageMLContext(dataProvider);
    String input = "<messageML><card><header>Hello</header><body>world!</body></card></messageML>";

    context.parseMessageML(input, null, MessageML.MESSAGEML_VERSION);

    Element messageML = context.getMessageML();
    Element card = messageML.getChildren().get(0);

    return messageML;
  }

}
