/*
  Web Server
 
 A simple web server that shows the value of the analog input pins.
 using an Arduino Wiznet Ethernet shield. 
 
 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13
 * Analog inputs attached to pins A0 through A5 (optional)
 
 created 18 Dec 2009
 by David A. Mellis
 modified 9 Apr 2012
 by Tom Igoe
 
 */

#include <SPI.h>
#include <Ethernet.h>

//button
const int BT = 9;

const int ledPin0 = 5;
const int ledPin1 = 6;
const int ledPin2 = 7;
const int ledPin3 = 8; //Sets pins for leds

int homeRegion = 666;

int money = 11; //money owns by arduino

// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network:
byte mac[] = { 0x90, 0xA2, 0xDA, 0x0D, 0x2F, 0x01 };
IPAddress ip(192,168,0,144);

// Initialize the Ethernet server library
// with the IP address and port you want to use 
// (port 80 is default for HTTP):
EthernetServer server(80);



void setup() {
  
   pinMode(ledPin0, OUTPUT);
   pinMode(ledPin1, OUTPUT);
   pinMode(ledPin2, OUTPUT);
   pinMode(ledPin3, OUTPUT); // Sets the leds output
  
 // Open serial communications and wait for port to open:
  Serial.begin(9600);
   while (!Serial) {
    ; // wait for serial port to connect. Needed for Leonardo only
  }


  // start the Ethernet connection and the server:
  Ethernet.begin(mac, ip);
  server.begin();
  Serial.print("server is at ");
  Serial.println(Ethernet.localIP());
}


void loop() {
  // listen for incoming clients
  EthernetClient client = server.available();
  if (client) {
    Serial.println("new client");
    // an http request ends with a blank line
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      if (client.available()) {
        char c = client.read();
        Serial.write(c);
        // if you've gotten to the end of the line (received a newline
        // character) and the line is blank, the http request has ended,
        // so you can send a reply
        if (c == '\n' && currentLineIsBlank) {
          // send a standard http response header
          client.println("HTTP/1.1 200 OK");
          client.println("Content-Type: text/html");
          client.println("Connection: close");  // the connection will be closed after completion of the response
	  client.println("Refresh: 5");  // refresh the page automatically every 5 sec
          client.println();
          client.println("<!DOCTYPE HTML>");
          client.println("<html>");
          
          
          // output the value of each analog input pin
          
            client.print("My bounty is: ");
            client.println(money - 1);
            client.print("Giving you one.");
            client.println(1);
            Serial.println(money);
            money--;
            ledOutput();
            client.println("<br />");                 
          
          client.println("</html>");
          break;
        }
        
        if (c == '\n') {
          // you're starting a new line
          currentLineIsBlank = true;
        } else if (c != '\r') {
          // you've gotten a character on the current line
          currentLineIsBlank = false;
        }
      }
    }
    // give the web browser time to receive the data
    delay(1);
    // close the connection:
    client.stop();
    Serial.println("client disonnected");
  }
}

void ledOutput(){

  if (money == 10){
      digitalWrite(ledPin0, HIGH);
      digitalWrite(ledPin1, LOW);
      digitalWrite(ledPin2, HIGH);
      digitalWrite(ledPin3, LOW);
      
  } else if (money == 9){
      digitalWrite(ledPin0, LOW);
      digitalWrite(ledPin1, HIGH);
      
  } else if (money == 8){
      digitalWrite(ledPin0, HIGH);
      
  } else if (money == 7){
      digitalWrite(ledPin0, LOW);
      digitalWrite(ledPin1, LOW);
      digitalWrite(ledPin2, LOW);
      digitalWrite(ledPin3, HIGH);
      
  } else if (money == 6){
      digitalWrite(ledPin0, HIGH);
      
  } else if (money == 5){
      digitalWrite(ledPin0, LOW);
      digitalWrite(ledPin1, HIGH);
      
  } else if (money == 4){
      digitalWrite(ledPin0, HIGH);
      
  } else if (money == 3){
      digitalWrite(ledPin0, LOW);
      digitalWrite(ledPin1, LOW);
      digitalWrite(ledPin2, HIGH);
      
  } else if (money == 2){
      digitalWrite(ledPin0, HIGH);
      
  } else if (money == 1){
      digitalWrite(ledPin0, LOW);
      digitalWrite(ledPin1, HIGH);
      
  } else if (money == 0){
      digitalWrite(ledPin0, HIGH);
      money = 11;      
  }  
  
}

