/*
  Web client
 
 This sketch connects to a website (http://www.google.com)
 using an Arduino Wiznet Ethernet shield. 
 
 Circuit:
 * Ethernet shield attached to pins 10, 11, 12, 13
 
 created 18 Dec 2009
 by David A. Mellis
 modified 9 Apr 2012
 by Tom Igoe, based on work by Adrian McEwen
 
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

// Enter a MAC address for your controller below.
// Newer Ethernet shields have a MAC address printed on a sticker on the shield
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
// if you don't want to use DNS (and reduce your sketch size)
// use the numeric IP instead of the name for the server:
IPAddress server(192,168,0,102);  // numeric IP for server (no DNS)
//char server[] = "www.google.com";    // name address for Google (using DNS)

// Set the static IP address to use if the DHCP fails to assign
IPAddress ip(192,168,0,144);

// Initialize the Ethernet client library
// with the IP address and port of the server 
// that you want to connect to (port 80 is default for HTTP):
EthernetClient client;

void setup() {
  
 pinMode(ledPin0, OUTPUT);
 pinMode(ledPin1, OUTPUT);
 pinMode(ledPin2, OUTPUT);
 pinMode(ledPin3, OUTPUT); // Sets the leds output
 
 
 // Open serial communications and wait for port to open:
  Serial.begin(115200);
   while (!Serial) {
    ; // wait for serial port to connect. Needed for Leonardo only
  }

  // start the Ethernet connection:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    // no point in carrying on, so do nothing forevermore:
    // try to congifure using IP address instead of DHCP:
    Ethernet.begin(mac, ip);
  }
  // give the Ethernet shield a second to initialize:
  delay(1000);
  Serial.println("connecting...");

  // if you get a connection, report back via serial:
  if (client.connect(server, 80)) {
    Serial.println("connected");
    // Make a HTTP request:
    client.println("GET /search?q=arduino HTTP/1.1");
    client.println();
  } 
  else {
    // kf you didn't get a connection to the server:
    Serial.println("connection failed");
  }
}

void loop(){
  
  // if there are incoming bytes available 
  // from the server, read them and print them:
  if (client.available()) {
    char c = client.read();
    Serial.print(c);
  }

  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println();
    Serial.println("disconnecting.");
    client.stop();

    // do nothing forevermore:
    while(true);
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
