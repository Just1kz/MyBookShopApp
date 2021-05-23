package com.example.MyBookShopApp.config;

import com.example.MyBookShopApp.dto.TestEntity;
import com.example.MyBookShopApp.repository.AuthorRepository;
import com.example.MyBookShopApp.repository.BookRepository;
import com.example.MyBookShopApp.repository.TestEntityCrudRepository;
import com.example.MyBookShopApp.repository.TestEntityDao;
import com.example.MyBookShopApp.service.AuthorsService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import java.util.logging.Logger;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    TestEntityCrudRepository testEntityCrudRepository;
    BookRepository bookRepository;
    AuthorsService authorsService;

    @Autowired
    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository, BookRepository bookRepository, AuthorsService authorsService) {
        this.testEntityCrudRepository = testEntityCrudRepository;
        this.bookRepository = bookRepository;
        this.authorsService = authorsService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0;  i < 5; i++) {
            createTestEntity(new TestEntity());
        }

        TestEntity readTestEntity =  readTestEntityById(3L); //testEntityDao.findOne(3L);
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("read" + readTestEntity.toString());

        TestEntity updateTestEntity = updateTestEntityById(5L);
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update" + updateTestEntity.toString());

        deleteTestEntityDyId(4L);

        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBookByTitle("Biodex").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBookByAuthor_LastName("Peaden").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBookByAuthor_FirstName("Feliza").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBookByAuthor_LastNameLowerCase("bone").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("findByTitle: " + bookRepository.findAllByTitleContains("dal").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("findByTitleLower: " + bookRepository.findAllByTitleLowerCase("bio").toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.customAllBooks().toString());
        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(authorsService.getAuthorsMapJPA().toString());
    }

    private void deleteTestEntityDyId(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Long id) {
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setDate("NEW DATA");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Long id) {
        return testEntityCrudRepository.findById(id).get();
    }

    private void createTestEntity(TestEntity testEntity) {
        testEntity.setDate(testEntity.getClass().getSimpleName() + testEntity.hashCode());
        testEntityCrudRepository.save(testEntity);
    }
}
