package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[]str=screenDimensions.split("X");
        Image image=imageRepository2.findById(id).get();
        String imgDim=image.getDimensions();
        String[] str1=imgDim.split("X");
        int scr1=Integer.parseInt(str[0]);
        int scr2=Integer.parseInt(str[1]);

        int img1=Integer.parseInt(str[0]);
        int img2=Integer.parseInt(str[1]);
        return numbImage(scr1,scr2,img1,img2);
    }
   public  int numbImage(int scr1,int scr2,int img1,int img2){
        int len1=scr1/img1;
        int len2=scr2/img2;
        return len1*len2;
}

}
