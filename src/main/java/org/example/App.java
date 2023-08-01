package org.example;
import org.example.entity.Comment;
import org.example.entity.Post;
import org.example.entity.Profile;
import org.example.entity.User;
import org.example.enums.Gender;
import org.example.service.serviceImpl.CommentServiceImpl;
import org.example.service.serviceImpl.PostServiceImpl;
import org.example.service.serviceImpl.ProfileServiceImpl;
import org.example.service.serviceImpl.UserServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        EntityManager entityManager= HibernateDataBase.getEntityManager();
        UserServiceImpl userService = new UserServiceImpl();
        ProfileServiceImpl profileService= new ProfileServiceImpl();
        PostServiceImpl postService= new PostServiceImpl();
        CommentServiceImpl commentService = new CommentServiceImpl();

        User user = new User("Baktulan","baku@mail.ru","1234baku");
        User user1 = new User("Dani","dani@mail.ru","Daniel123");
        User user2 = new User("Akylai","akylai@mail.ru","1234");

        Profile profile= new Profile("Baktulan Nazibek uulu", LocalDate.of(2000,4,10), Gender.MALE,"text");
        Profile profile1= new Profile("Daniel Gafurov", LocalDate.of(2002,7,13), Gender.MALE,"text1");
        Profile profile2= new Profile("Akylai", LocalDate.of(2001,4,10), Gender.FEMALE,"text3");

        Post post = new Post("Photo","comment1",LocalDate.of(2023,1,1));
        Post post1 = new Post("Image","comment2",LocalDate.of(2023,2,6));
        Post post2 = new Post("Surot","comment3",LocalDate.of(2023,3,5));

        Comment comment1 = new Comment("Good job",LocalDate.of(2023,4,1));
        Comment comment2 = new Comment("Good news",LocalDate.of(2023,2,2));
        Comment comment3 = new Comment("Congratulations",LocalDate.of(2023,5,7));



//        System.out.println(userService.saveUser(user2));
//        System.out.println(userService.findUserById(1L));
//        System.out.println(userService.updateUserProfile(5L, profile2));
//        System.out.println(userService.deleteUser(2L));

//        System.out.println(profileService.saveProfile(3L, profile2));
//        System.out.println(profileService.findProfilrByUserId(1L));
//        System.out.println(profileService.deleteProfileByUserId(3L));

//        System.out.println(postService.savePost(3L, post2));
//        System.out.println(postService.getPostsByUserId(3L));
//        System.out.println(postService.searchPost(2L));
//        System.out.println(postService.deletePostById(3L));

//        System.out.println(commentService.saveComment(4L, 3L, comment1));


    }
}
