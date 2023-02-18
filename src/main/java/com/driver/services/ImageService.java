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
        Image image=new Image();

        image.setDescription(description);
        image.setDimensions(dimensions);

        Blog blog=blogRepository2.findById(blogId).get();
        image.setBlog(blog);

        List<Image>imageList=blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);

        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository2.findById(id).get();
        String imgDim=image.getDimensions();

        String[]str=screenDimensions.split("X");
        String[] str1=imgDim.split("X");

        int scr1=Integer.valueOf(str[0]);
        int scr2=Integer.valueOf(str[1]);

        int img1=Integer.parseInt(str[0]);
        int img2=Integer.parseInt(str[1]);

        int len1=scr1/img1;
        int len2=scr2/img2;
        return len1*len2;
    }
}
