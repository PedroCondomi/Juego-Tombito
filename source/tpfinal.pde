//Pedrito Condomí

import ddf.minim.*;

Minim minim;
AudioPlayer  musik1, musik2, musik3, musikini;
AudioSample jumpin, losing, winin;

PImage Nivel1, Nivel2, Nivel3, playerder, playerizq, inicio, pasarlvl2, pasarlvl3, perder, ganar, platcor, platlar;
int salto, back, paso;
boolean caer;
float rectX, rectY, rectmovX, rectmovY, pYfall, fondoX, fondoY;
float plat1X, plat1Y;
float plat2X, plat2Y;
float plat3X, plat3Y;
float plat4X, plat4Y;
float plat1mov, plat2mov, plat3mov, plat4mov;


void setup () {
  minim = new Minim(this);
  size (1280, 720);
  back = 1;
  platcor = loadImage ("platcor.gif");
  platlar = loadImage ("platlar.gif");
  playerder = loadImage ("pengder.gif"); //64x30 px
  playerizq = loadImage ("pengizq.gif"); //64x30 px
  inicio = loadImage ("pantalla inicio.gif");
  pasarlvl2 =loadImage ("pantalla nivel 2.gif");
  pasarlvl3 = loadImage ("pantalla nivel 3.gif");
  perder = loadImage ("pantalla perdiste.gif");
  ganar =loadImage ("pantalla ganaste.gif");
  Nivel1 = loadImage ("nivel1200.gif");
  Nivel2 = loadImage ("nivel20.gif");
  Nivel3 = loadImage ("lvl3.gif");
  winin = minim.loadSample ("gane.mp3");
  losing = minim.loadSample ("perdi.mp3");
  jumpin = minim.loadSample ("salte.mp3");
  jumpin.setGain(-5);
  musikini = minim.loadFile ("iniciost.mp3");
  musikini.loop();
  musik3 = minim.loadFile ("musica3.mp3");
  musik2 = minim.loadFile ("musica2.mp3");
  musik1 = minim.loadFile ("musica1.mp3");
  caer = false;
  rectX = 70;
  rectY = 680;
  paso = 0;
  fondoX= 0;
  fondoY = 0;
  rectmovX = 2.3;
  rectmovY = -10.2;
  salto = 2;  
  pYfall =0.4;
  plat1X = 980;
  plat1Y = 310;
  plat2X = 480;
  plat2Y = 310;
  plat3X = 406;
  plat3Y = 605;
  plat4X = 838;
  plat4Y = 20;
  plat1mov = 1.5;
  plat2mov = 1.5;
  plat3mov = 1.5;
  plat4mov = 1.5;
}

void draw () {
  if (paso == 0) {
    Inicio();
  }
  if (paso == 1) {
    Level1();
  }
  if (paso == 2) {
    Perder();
  }
  if (paso == 3) {
    Iniciolvl2();
  }
  if (paso == 4) {
    Level2();
  }
  if (paso == 5) {
    Perder();
  }
  if (paso == 6) {
    Iniciolvl3();
  }
  if (paso == 7) {
    Level3();
  }
  if (paso == 8) {
    Perder();
  }
  if (paso == 9) {
    Ganar();
  }
}




void keyPressed() {
  if ((keyCode == UP) && (caer == false)) {
    if (salto == 0) {
      jumpin.trigger();
    }

    salto = 1;
  }
  if (keyCode == LEFT) {
    rectmovX = -2.3;
  }
  if (keyCode == RIGHT) {
    rectmovX = 2.3;
  }

  if (key == 'l') {
    paso = paso + 1;
    if (paso == 4) {
      rectX = 1100;
      rectY = 640;
    }
    if (paso == 1) {
      musikini.pause();
      musik1.loop();
    }
    if (paso == 4) {
      musikini.pause();
      musik1.pause();
      musik2.loop();
    }
    if (paso == 7) {
      musikini.pause();
      musik1.pause();
      musik2.pause();
      musik3.loop();
    }
  }
  if (paso == 2) {
    if (key == 'r') {
      paso = 1;
      rectX = 70;
      rectY = 680;
    }
  }
  if (paso == 5) {
    if (key == 'r') {
      paso = 4;
      rectX = 1100;
      rectY = 640;
    }
  }
  if (paso == 8) {
    if (key == 'r') {
      paso = 7;
      rectX = 1180;
      rectY = 665;
    }
  }
  if (paso == 0) {
    if (key == 's') {
      paso = 1;
      rectX = 70;
      rectY = 680;
      musikini.pause();
      musik1.loop();
    }
  }
  if (paso == 3) {
    if (key == 's') {
      paso = 4;
      rectX = 1100;
      rectY = 640;
      musikini.pause();
      musik1.pause();
      musik2.loop();
    }
  }
  if (paso == 6) {
    if (key == 's') {
      paso = 7;
      rectX = 1180;
      rectY = 665;
      musikini.pause();
      musik1.pause();
      musik2.pause();
      musik3.loop();
    }
  }
}
