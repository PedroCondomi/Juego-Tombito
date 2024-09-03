void Level3 () {
  background (189,243,255);
  imageMode (CORNER);
  image (Nivel3, fondoX, fondoY);
  noStroke ();
  fill (200, 0, 0);
  imageMode (CENTER);

  image (platlar, plat1X, plat1Y);
  image (platlar, plat2X, plat2Y);
  image (platlar, plat3X, plat3Y);
  image (platcor, plat4X, plat4Y);
  if (rectmovX <= -2.3) {
    image (playerizq, rectX, rectY, 64, 30);
  }
  if (rectmovX >= 2.3) {
    image (playerder, rectX, rectY, 64, 30);
  }

  rectX = rectX + rectmovX;
  plat1X = plat1X + plat1mov;
  plat2X = plat2X + plat2mov;
  plat3X = plat3X + plat3mov;
  plat4X = plat4X + plat4mov;

  if (plat1X >= 1075) {
    plat1mov = -1.5;
  }
  if (plat1X <= 880) {
    plat1mov = 1.5;
  }

  if (plat2X >= 525) {
    plat2mov = -1.5;
  }
  if (plat2X <= 420) {
    plat2mov = 1.5;
  }
  if (plat3X >= 530) {
    plat3mov = -1.5;
  }
  if (plat3X <= 250) {
    plat3mov = 1.5;
  }
  if (plat4X >= 1000) {
    plat4mov = -1.5;
  }
  if (plat4X <= 800) {
    plat4mov = 1.5;
  }






  //salto
  if (salto == 1) {
    if ((get(int(rectX), int(rectY-19)) == color (0)) //colisión arriba
      || (get(int(rectX), int(rectY-19)) == color (255))
      || (get(int(rectX), int(rectY-19)) == color (94, 179, 255))
      || (get(int(rectX), int(rectY-19)) == color (154, 133, 255))
      || (get(int(rectX), int(rectY-19)) == color (178, 194, 255))
      || (get(int(rectX), int(rectY-19)) == color (156, 223, 255))) { 
      rectmovY =0.4;
    }
    rectmovY = rectmovY + 0.4;
    rectY = rectY + rectmovY;
  }




  if ((get(int(rectX), int(rectY+16)) == color (0))  //colisión abajo
    || (get(int(rectX), int(rectY+16)) == color (255))
    || (get(int(rectX), int(rectY+16)) == color (94, 179, 255))
    || (get(int(rectX), int(rectY+16)) == color (154, 133, 255))
    || (get(int(rectX), int(rectY+16)) == color (178, 194, 255))
    || (get(int(rectX), int(rectY+16)) == color (156, 223, 255))) { 
    salto = 0;
    rectmovY = -10.2;
  } else {
  }

  if ((salto == 0) && (get(int(rectX), int(rectY+17)) == color (189,243,255))) { //caer
    caer = true;
  } else {
    caer = false; //no caer
    pYfall = 0.4;
  }

  if (caer == true) {
    rectY = rectY + pYfall; //caer
    pYfall = pYfall + 0.4;
  }




  //mov lateral
  if ((get(int (rectX +27), int(rectY)) == color (0)) 
    || (get(int (rectX +27), int(rectY)) == color (255))
    || (get(int (rectX +27), int(rectY)) == color (94, 179, 255))
    || (get(int(rectX +27), int(rectY)) == color (154, 133, 255))
    || (get(int(rectX +27), int(rectY)) == color (178, 194, 255))
    || (get(int (rectX +27), int(rectY)) == color (156, 223, 255))) { //colisión derecha
    if (rectmovX == 2.3) {
      rectmovX = -2.3;
    }
  }
  if ((get(int (rectX -27), int(rectY)) == color (0)) 
    || (get(int (rectX -27), int(rectY)) == color (255))
    || (get(int (rectX -27), int(rectY)) == color (94, 179, 255))
    || (get(int(rectX -27), int(rectY)) == color (154, 133, 255))
    || (get(int(rectX -27), int(rectY)) == color (178, 194, 255))
    || (get(int (rectX -27), int(rectY)) == color (156, 223, 255))) { //colisión izquierda
    if (rectmovX == -2.3) {
      rectmovX = 2.3;
    }
  }

  if ((get(int (rectX +25), int(rectY)) == color (0, 0, 107)) 
    || (get(int (rectX +25), int(rectY)) == color (71, 0, 194))
    || (get(int (rectX +25), int(rectY)) == color (20, 30, 107))) { //colisión derecha espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(int (rectX -25), int(rectY)) == color (0, 0, 107)) 
    || (get(int (rectX -25), int(rectY)) == color (71, 0, 194))
    || (get(int (rectX -25), int(rectY)) == color (20, 30, 107))) { //colisión izquierda espina 
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(int (rectX), int(rectY+16)) == color (0, 0, 107)) 
    || (get(int (rectX), int(rectY+16)) == color (71, 0, 194))
    || (get(int (rectX), int(rectY+16)) == color (20, 30, 107))) { //colisión abajo espina
    paso = paso + 1;
    losing.trigger();
  }
  if ((get(int (rectX), int(rectY-19)) == color (0, 0, 107)) 
    || (get(int (rectX), int(rectY-19)) == color (71, 0, 194))
    || (get(int (rectX), int(rectY-19)) == color (20, 30, 107))) { //colisión arriba espina
    paso = paso + 1;
    losing.trigger();
  }

  if ((get(int (rectX -26), int(rectY)) == color (178, 196, 75)) 
    || (get(int (rectX -26), int(rectY)) == color (0, 112, 139))
    || (get(int (rectX -26), int(rectY)) == color (41, 163, 188))
    || (get(int (rectX -26), int(rectY)) == color (125, 229, 230))
    || (get(int (rectX -26), int(rectY)) == color (55, 211, 229))
    || (get(int (rectX -26), int(rectY)) == color (0, 185, 215))
    || (get(int (rectX -26), int(rectY)) == color (44, 163, 187))) { //colisión izquierda iglu
    paso = paso + 2;
    winin.trigger();
  }
  if ((get(int (rectX), int(rectY+16)) == color (178, 196, 75)) 
    || (get(int (rectX), int(rectY+16)) == color (0, 112, 139))
    || (get(int (rectX), int(rectY+16)) == color (41, 163, 188))
    || (get(int (rectX), int(rectY+16)) == color (125, 229, 230))
    || (get(int (rectX), int(rectY+16)) == color (55, 211, 229))
    || (get(int (rectX), int(rectY+16)) == color (0, 185, 215))
    || (get(int (rectX), int(rectY+16)) == color (44, 163, 187))) { //colisión abajo iglu
    paso = paso + 2;
    winin.trigger();
  }
  if ((get(int (rectX), int(rectY-19)) == color (178, 196, 75)) 
    || (get(int (rectX), int(rectY-19)) == color (0, 112, 139))
    || (get(int (rectX), int(rectY-19)) == color (41, 163, 188))
    || (get(int (rectX), int(rectY-19)) == color (125, 229, 230))
    || (get(int (rectX), int(rectY-19)) == color (55, 211, 229))
    || (get(int (rectX), int(rectY-19)) == color (0, 185, 215))
    || (get(int (rectX), int(rectY-19)) == color (44, 163, 187))) { //colisión arriba iglu
    paso = paso + 2;
    winin.trigger();
  }
}
