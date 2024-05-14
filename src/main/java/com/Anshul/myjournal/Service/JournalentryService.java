package com.Anshul.myjournal.Service;

import com.Anshul.myjournal.Entities.JournalEntry;
import com.Anshul.myjournal.Entities.User;
import com.Anshul.myjournal.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalentryService {

    private static final Logger logger = LoggerFactory.getLogger(JournalentryService.class);

   @Autowired
   private JournalEntryRepository journalEntryRepository;

   @Autowired
   private UserService userService;


@Transactional
   public void SaveJournal(JournalEntry journalEntry, String userName){
      try {
          User user = userService.findByUserName(userName);
          journalEntry.setDate(LocalDateTime.now());
          JournalEntry savedentry = journalEntryRepository.save(journalEntry);
          user.getJournalEntries().add(savedentry);
          userService.saveUser(user);
          logger.info("error in JournalentryService | Save Journal");
      }
      catch(Exception e){
          logger.info(" error in JournalentryService | Save Journal",e);
          System.out.println(e);
          throw new RuntimeException("ana error occured",e);
      }
   }
    public void SaveJournal(JournalEntry journalEntry){
         journalEntryRepository.save(journalEntry);

    }

   public List<JournalEntry> getJournal(){
       List<JournalEntry> AllJournal =journalEntryRepository.findAll();
       return AllJournal;
   }

   public Optional<JournalEntry> getJournalById(ObjectId id){

      return journalEntryRepository.findById(id);
   }


   @Transactional
    public void deleteByID(ObjectId id,String userName){
        try {
            User user = userService.findByUserName(userName);
            boolean removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        }
            catch(Exception e){
                System.out.println(e+ "exception has occured while delete");
            }
        }

}
