/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Tran Ha
 */
public class BlendImage {

    public  Image blend(Image img1, Image img2, int value256, int type) {
        // 1. get blended image:
        int w1 = img1.getWidth();
        int h1 = img1.getHeight();
        int w2 = img2.getWidth();
        int h2 = img2.getHeight();

        int w0 = Math.min(w1, w2);
        int h0 = Math.min(h1, h2);
        int[] data = new int[w0 * h0];
        int[] b1 = new int[w0];
        int[] b2 = new int[w0];
        System.out.println("truoc blen");

        for (int offset = 0, i = 0; i < h0; i++) {
            img1.getRGB(b1, 0, w1, 0, i, w0, 1); // get one line from each
            img2.getRGB(b2, 0, w2, 0, i, w0, 1);

            for (int j = 0; j < w0; j++) // blend all pixels
            {
                data[offset++] = blend(b1[j], b2[j], value256, type);
            }
        }
        System.out.println("Blend");
        return Image.createRGBImage(data, w0, h0, true);
    }

    public  Image scaleImage(Image src, int dstW, int dstH) {
        int srcW = src.getWidth();
        int srcH = src.getHeight();

        Image tmp = Image.createImage(dstW, srcH);
        Graphics g = tmp.getGraphics();

        int delta = (srcW << 16) / dstW;
        int pos = delta / 2;

        for (int x = 0; x < dstW; x++) {
            g.setClip(x, 0, 1, srcH);
            g.drawImage(src, x - (pos >> 16), 0, Graphics.LEFT | Graphics.TOP);
            pos += delta;
        }

        Image dst = Image.createImage(dstW, dstH);
        g = dst.getGraphics();

        delta = (srcH << 16) / dstH;
        pos = delta / 2;

        for (int y = 0; y < dstH; y++) {
            g.setClip(0, y, dstW, 1);
            g.drawImage(tmp, 0, y - (pos >> 16), Graphics.LEFT | Graphics.TOP);
            pos += delta;
        }
        return dst;
    }

    public  final int blend(int c1, int c2, int value256, int type) {
        // how much should we take from each color?
        int v1 = value256 & 0xFF;
        int v2 = 255 - v1;
        // get components
        int A1 = (c1 >> 24) & 0xFF;
        int R1 = (c1 >> 16) & 0xFF;
        int G1 = (c1 >> 8) & 0xFF;
        int B1 = (c1 >> 0) & 0xFF;
        int A2 = (c2 >> 24) & 0xFF;
        int R2 = (c2 >> 16) & 0xFF;
        int G2 = (c2 >> 8) & 0xFF;
        int B2 = (c2 >> 0) & 0xFF;
        // mix them given the requested amount
//        int a = (a1 * v1 + a2 * v2) >> 8;
//        int r = (r1 * v1 + r2 * v2) >> 8;
//        int g = (g1 * v1 + g2 * v2) >> 8;
//        int b = (b1 * v1 + b2 * v2) >> 8;

        int A3 = 0, B3 = 0, G3 = 0, R3 = 0;
        switch (type) {
            case 1:
                A3 = A2 > A1 ? A2 : A1;
                R3 = R2 > R1 ? R2 : R1;
                G3 = G2 > G1 ? G2 : G1;
                B3 = B2 > B1 ? B2 : B1;
                break;
            case 2:
                A3 = A2 > A1 ? A1 : A2;
                R3 = R2 > R1 ? R1 : R2;
                G3 = G2 > G1 ? G1 : G2;
                B3 = B2 > B1 ? B1 : B2;
                break;
            case 4:
                A3 = A1 * A2 / 255;
                R3 = R1 * R2 / 255;
                G3 = G1 * G2 / 255;
                B3 = B1 * B2 / 255;
                break;
            case 5:
                A3 = A1 + A2 / 2;
                R3 = R1 + R2 / 2;
                G3 = G1 + G2 / 2;
                B3 = B1 + B2 / 2;
                break;
            case 6:
                A3 = Math.min(255, A1 + A2);
                R3 = Math.min(255, R1 + R2);
                G3 = Math.min(255, G1 + G2);
                B3 = Math.min(255, B1 + B2);
                break;
            case 7:
                A3 = (A1 + A2 < 255) ? 0 : (A1 + A2 - 255);
                R3 = (R1 + R2 < 255) ? 0 : (R1 + R2 - 255);
                G3 = (G1 + G2 < 255) ? 0 : (G1 + G2 - 255);
                B3 = (B1 + B2 < 255) ? 0 : (B1 + B2 - 255);
                break;
            case 8:
                A3 = Math.abs(A1 - A2);
                R3 = Math.abs(R1 - R2);
                G3 = Math.abs(G1 - G2);
                B3 = Math.abs(B1 - B2);
                break;
            case 9:
                A3 = 255 - Math.abs(255 - A1 - A2);
                R3 = 255 - Math.abs(255 - R1 - R2);
                G3 = 255 - Math.abs(255 - G1 - G2);
                B3 = 255 - Math.abs(255 - B1 - B2);
                break;
            case 10:
                A3 = 255 - (((255 - A1) * (255 - A2)) >> 8);
                R3 = 255 - (((255 - R1) * (255 - R2)) >> 8);
                G3 = 255 - (((255 - G1) * (255 - G2)) >> 8);
                B3 = 255 - (((255 - B1) * (255 - B2)) >> 8);
                break;
            case 11:
                A3 = (A1 + A2 - 2 * A1 * A2 / 255);
                R3 = (R1 + R2 - 2 * R1 * R2 / 255);
                G3 = (G1 + G2 - 2 * G1 * G2 / 255);
                B3 = (B1 + B2 - 2 * B1 * B2 / 255);
                break;
            case 12:
                A3 = ((A2 < 128) ? (2 * A1 * A2 / 255) : (255 - 2
                        * (255 - A1) * (255 - A2) / 255));
                R3 = ((R2 < 128) ? (2 * R1 * R2 / 255) : (255 - 2
                        * (255 - R1) * (255 - R2) / 255));
                G3 = ((G2 < 128) ? (2 * G1 * G2 / 255) : (255 - 2
                        * (255 - G1) * (255 - G2) / 255));
                B3 = ((B2 < 128) ? (2 * B1 * B2 / 255) : (255 - 2
                        * (255 - B1) * (255 - B2) / 255));
                break;
            case 13:
                A3 = (int) ((A2 < 128) ? (2 * ((A1 >> 1) + 64))
                        * ((float) A2 / 255)
                        : (255 - (2 * (255 - ((A1 >> 1) + 64))
                        * (float) (255 - A2) / 255)));
                R3 = (int) ((R2 < 128) ? (2 * ((R1 >> 1) + 64))
                        * ((float) R2 / 255)
                        : (255 - (2 * (255 - ((R1 >> 1) + 64))
                        * (float) (255 - R2) / 255)));
                G3 = (int) ((G2 < 128) ? (2 * ((G1 >> 1) + 64))
                        * ((float) G2 / 255)
                        : (255 - (2 * (255 - ((G1 >> 1) + 64))
                        * (float) (255 - G2) / 255)));
                B3 = (int) ((B2 < 128) ? (2 * ((B1 >> 1) + 64))
                        * ((float) B2 / 255)
                        : (255 - (2 * (255 - ((B1 >> 1) + 64))
                        * (float) (255 - B2) / 255)));
                break;
            case 14:
                A3 = (A1 < 128) ? (2 * A2 * A1 / 255) : (255 - 2
                        * (255 - A2) * (255 - A1) / 255);
                R3 = (R1 < 128) ? (2 * R2 * R1 / 255) : (255 - 2
                        * (255 - R2) * (255 - R1) / 255);
                G3 = (G1 < 128) ? (2 * G2 * G1 / 255) : (255 - 2
                        * (255 - G2) * (255 - G1) / 255);
                B3 = (B1 < 128) ? (2 * B2 * B1 / 255) : (255 - 2
                        * (255 - B2) * (255 - B1) / 255);
                break;
            case 15:
                A3 = (A2 == 255) ? A2 : Math.min(255, ((A1 << 8) / (255
                        - A2)));
                R3 = (R2 == 255) ? R2 : Math.min(255,
                        ((R1 << 8) / (255 - R2)));
                G3 = (G2 == 255) ? G2 : Math.min(255,
                        ((G1 << 8) / (255 - G2)));
                B3 = (B2 == 255) ? B2 : Math.min(255,
                        ((B1 << 8) / (255 - B2)));
                break;
            case 16:
                A3 = (A2 == 0) ? A2 : Math.max(0, (255 - ((255 - A1) << 8)
                        / A2));
                R3 = (R2 == 0) ? R2 : Math.max(0, (255 - ((255 - R1) << 8)
                        / R2));
                G3 = (G2 == 0) ? G2 : Math.max(0, (255 - ((255 - G1) << 8)
                        / G2));
                B3 = (B2 == 0) ? B2 : Math.max(0, (255 - ((255 - B1) << 8)
                        / B2));
                break;

            case 17:
                A3 = 255 - (((255 - A1) * (255 - A2)) >> 8);
                R3 = 255 - (((255 - R1) * (255 - R2)) >> 8);
                G3 = 255 - (((255 - G1) * (255 - G2)) >> 8);
                B3 = 255 - (((255 - B1) * (255 - B2)) >> 8);
                break;

            case 18:
                A3 = (A1 + A2 < 255) ? 0 : (A1 + A2 - 255);
                R3 = (R1 + R2 < 255) ? 0 : (R1 + R2 - 255);
                G3 = (G1 + G2 < 255) ? 0 : (G1 + G2 - 255);
                B3 = (B1 + B2 < 255) ? 0 : (B1 + B2 - 255);
                break;
            case 19:
                A3 = (A2 < 128) ? (A1 + A2 * 2 < 255) ? 0 : (A1 + A2 * 2 - 255)
                        : (A1 + 2 * (A2 - 128) < 255) ? 0 : (A1 + 2 * (A2 - 128) - 255);
                R3 = (R2 < 128) ? (R1 + R2 * 2 < 255) ? 0
                        : (R1 + R2 * 2 - 255)
                        : (R1 + 2 * (R2 - 128) < 255) ? 0 : (R1 + 2
                        * (R2 - 128) - 255);
                G3 = (G2 < 128) ? (G1 + G2 * 2 < 255) ? 0
                        : (G1 + G2 * 2 - 255)
                        : (G1 + 2 * (G2 - 128) < 255) ? 0 : (G1 + 2
                        * (G2 - 128) - 255);
                B3 = (B2 < 128) ? (B1 + B2 * 2 < 255) ? 0
                        : (B1 + B2 * 2 - 255)
                        : (B1 + 2 * (B2 - 128) < 255) ? 0 : (B1 + 2
                        * (B2 - 128) - 255);
                break;
            case 20:
                A3 = (A2 < 128) ? (2 * A2 == 0) ? 2 * A2 : Math.max(0, (255
                        - ((255 - A1) << 8) / 2 * A2)) : (2 * (A2 - 128) == 255)
                        ? 2 * (A2 - 128) : Math.min(255, ((A1 << 8) / (255
                        - 2 * (A2 - 128))));
                R3 = (R2 < 128) ? (2 * R2 == 0) ? 2 * R2 : Math.max(0,
                        (255 - ((255 - R1) << 8) / 2 * R2))
                        : (2 * (R2 - 128) == 255) ? 2 * (R2 - 128)
                        : Math.min(
                        255,
                        ((R1 << 8) / (255 - 2 * (R2 - 128))));
                G3 = (G2 < 128) ? (2 * G2 == 0) ? 2 * G2 : Math.max(0,
                        (255 - ((255 - G1) << 8) / 2 * G2))
                        : (2 * (G2 - 128) == 255) ? 2 * (G2 - 128)
                        : Math.min(
                        255,
                        ((G1 << 8) / (255 - 2 * (G2 - 128))));
                B3 = (B2 < 128) ? (2 * B2 == 0) ? 2 * B2 : Math.max(0,
                        (255 - ((255 - B1) << 8) / 2 * B2))
                        : (2 * (B2 - 128) == 255) ? 2 * (B2 - 128)
                        : Math.min(
                        255,
                        ((B1 << 8) / (255 - 2 * (B2 - 128))));
                break;
            case 21:
                A3 = (A2 < 128) ? 2 * A2 > A1 ? A1 : 2 * A2 : 2 * (A2 - 128) > A1
                        ? 2 * (A2 - 128) : A1;
                R3 = (R2 < 128) ? 2 * R2 > R1 ? R1 : 2 * R2
                        : 2 * (R2 - 128) > R1 ? 2 * (R2 - 128) : R1;
                G3 = (G2 < 128) ? 2 * G2 > G1 ? G1 : 2 * G2
                        : 2 * (G2 - 128) > G1 ? 2 * (G2 - 128) : G1;
                B3 = (B2 < 128) ? 2 * B2 > B1 ? B1 : 2 * B2
                        : 2 * (B2 - 128) > B1 ? 2 * (B2 - 128) : B1;
                break;




        }



        return (A3 << 24) | (R3 << 16) | (G3 << 8) | B3;
    }
}
