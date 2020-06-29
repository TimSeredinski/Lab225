package com.epam.jpa;

import com.epam.jpa.dao.AccountDAO;
import com.epam.jpa.dao.CommentDAO;
import com.epam.jpa.dao.PostDAO;
import com.epam.jpa.entity.*;
import com.epam.jpa.entity.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tsimafei.seradzinski
 */
@Component
public class DataInit implements ApplicationRunner {
    private AccountDAO accountDAO;
    private CommentDAO commentDAO;
    private PostDAO postDAO;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public DataInit(AccountDAO accountDAO, CommentDAO commentDAO, PostDAO postDAO) {
        this.accountDAO = accountDAO;
        this.commentDAO = commentDAO;
        this.postDAO = postDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Account account = new Account();
        AccountID accountID = new AccountID("1", AccountType.DEFAULT);
        account.setAccountID(accountID);
        account.setName("Tim");
        accountDAO.save(account);

        Account account2 = new Account();
        AccountID accountID2 = new AccountID("2", AccountType.ADMIN);
        account2.setAccountID(accountID2);
        account2.setName("Nick");
        accountDAO.save(account2);

        PostID postID = new PostID("1", "1");
        Post post = new Post(postID, new ArrayList<>(), account);
        postDAO.save(post);

        Comment comment = new Comment();
        comment.setText("Some comment 1");
        comment.setAccount(accountDAO.findById(accountID).get());
        comment.setPost(post);
        commentDAO.save(comment);

        Comment comment2 = new Comment();
        comment2.setText("Some comment 2");
        comment2.setAccount(accountDAO.findById(accountID2).get());
        //to check n+1 solution query finds only 1 comment
        //comment2.setPost(post);
        commentDAO.save(comment2);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment2);

        Post postToUpdate = postDAO.findById(postID).get();
        postToUpdate.setComments(comments);
        postDAO.save(postToUpdate);

        Query query = entityManager.createNamedQuery("Account.findAll");
        List<Account> accountList = (ArrayList<Account>) query.getResultList();
        for(Account a : accountList)
        {
            System.out.println("NamedQuery " + a.getAccountID().getAccountType().name());
        }

        List<Comment> commentList = commentDAO.findAllComments();
        for(Comment c : commentList)
        {
            System.out.println("NamedQuery " + c.getText());
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("postID"), postID));

        Post criteriaApiPost = entityManager.createQuery(criteriaQuery).getSingleResult();
        System.out.println("Criteria API PostID: " + criteriaApiPost.getPostID().getPostID());
        System.out.println("Criteria API AccountID: " + criteriaApiPost.getPostID().getAccountID());

        System.out.println("Native Query " + commentDAO.findSecondComment().getText());

//        Criteria criteria = entityManager.crit(Manufacturer.class);
//        criteria.setFetchMode("contact", FetchMode.EAGER);

    }

}
