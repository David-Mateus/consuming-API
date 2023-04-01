import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Graphics2D;

public class GeradoraDeFigurinhas {

   public void cria(InputStream inputStream, String nomeArquivo ) throws Exception{
        //leitura da imagem
        
        BufferedImage imageOriginal =  ImageIO.read(inputStream);
        // criar uma nova image
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem =  new BufferedImage(largura,  novaAltura, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para a nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);
        //configura a fonte
        // graphics é nossa canta pra qualquer alteraão na imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(java.awt.Color.red);
        
        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 200, novaAltura - 150);
        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        
       
    }

    
}
