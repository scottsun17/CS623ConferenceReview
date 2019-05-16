
#Insert data to Author table
INSERT INTO Author (emailAddr, firstName, lastName) VALUES 
	('author-without-paper@will-be-deleted.com','Stupid','Silly'),
	('bnansom0@accuweather.com','Bancroft','Nansom'),
	('tchifney1@buzzfeed.com','Travers','Chifney'),
	('rbankes2@google.co.jp','Roby','Bankes'),
	('pfritz3@g.co','Pia','Fritz'),
	('lpeppett4@sfgate.com','Lorens','Peppett'),
	('tvibert5@msu.edu','Tabina','Vibert');

#Insert data to Topic
INSERT INTO Topic(TopicName) VALUES
	('Environment'),
	('Money'),
	('Education');

#Insert data to Reviewer table
INSERT INTO Reviewer (emailAddr, firstName, lastName, authorFeedBack, commiteeFeedBack, phoneNum, affiliation, topicId) VALUES
	('cbinne23@apache.org', 'Cristin', 'Binne', "She is just amazing. I am completely blown away.", "This is unbelievable. After using her review my buisness skyrocketed!", '(425)332-6136', 'King Ltd', 1), 
	('spiotrkowski24@bloglines.com', 'Stefano', 'Piotrkowski', "I have gotten at least 50 times the value from Book. This is simply unbelievable! Buy this now. I just can't get enough of Book. I want to get a T-Shirt with Book on it so I can show it off to everyone.", "I like Book more and more each day because it makes my life a lot easier. Very easy to use.", '(563)929-3088', 'Mayert LLC', 2), 
	('rderuggiero25@sun.com', 'Rey', 'De Ruggiero', "Thank you so much for your help. I will recommend you to my colleagues. Since I invested in Reviewer I made over 100,000 dollars profits.", "If you aren't sure, always go for Reviewer. I couldn't have asked for more than this.", '(607)772-5880', 'Bashirian Ltd', 3);

#Insert data to Paper table
INSERT INTO Paper (title, authorId, reviewerId, absrract, fileName) VALUES
	('The Ugly Truth About ANIMAL', 'bnansom0@accuweather.com', 'cbinne23@apache.org',"Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful", 'SedSagittis.ppt'),
	('Do Not Fall For This ANIMAL Scam', 'rbankes2@google.co.jp', 'cbinne23@apache.org',"This is what is going to kill you if you do not listen to me right now right here!", 'Failed.ppt'),
	('17 Tricks About DOOR You Wish You Knew Before', 'pfritz3@g.co', 'cbinne23@apache.org',"The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz. Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Quick wafting zephyrs vex bold Jim. Quick zephyrs blow, vexing daft Jim. Sex-charged fop blew my junk TV quiz. How quic", 'Door.txt'),
	('Rules Not To Follow About ORANGE', 'lpeppett4@sfgate.com', 'spiotrkowski24@bloglines.com',"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those", 'Cicero.txt'),
	('LANGUAGE Conferences', 'tvibert5@msu.edu', 'spiotrkowski24@bloglines.com',"The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To achieve this, it would be necessary to have uniform", 'Language.ppt'),
	('The Secrets To DC', 'tchifney1@buzzfeed.com', 'spiotrkowski24@bloglines.com',"Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment.", 'History.md'),
	('I am a Fake Title', 'tchifney1@buzzfeed.com', 'rderuggiero25@sun.com',"This is fake dummy data that you will probably never notice it, so what can you do about it? Nothing :p", 'silly.text');


#Insert data to Review table
INSERT INTO Review(recommendation, meritScore, readabilityScore, relevanceScore, originalityScore, paperId, reviewerId) VALUES
	("Posting a buyer feedback is a proven and successful way to receive positive feedback from buyers. Once you post a review for buyer, ebay system informs the buyer about a feedback. This acts as very effective means to motivate buyer for rating the seller as well.", 10, 9, 8, 6, 1, 'cbinne23@apache.org'),
	("As a busy eBay seller, you may have a lot of things to do. This may leave you with very less time to leave feedback.", 8, 9, 7, 3, 2, 'cbinne23@apache.org'),
	("In addition to that following things can help you get better feedback.", 8, 2, 9, 6, 2, 'spiotrkowski24@bloglines.com'),
	("The feedback suggested by this tool are absolutely free for you to use. You can easily copy it from the suggestion text box and use any way you like.", 4,7,5,8, 3, 'rderuggiero25@sun.com'),
	("Keep trying until you really discover your favorite feedback text.", 4, 6, 8, 4, 4, 'rderuggiero25@sun.com'),
	("This is a free online tool to generate a short positive feedback for a ebay user. This tool takes care of randomly picking a good feedback from list of various different text.", 4, 6, 7, 3, 5, 'spiotrkowski24@bloglines.com'),
	("Buy LinkedIn Recommendations, LinkedIn Endorsements, connections, likes, followers or hight quality motivational quote images from us!", 7, 6, 9, 3, 6, 'rderuggiero25@sun.com'),
	("We are all excited about the returning of Game of Thrones Season 8. Let talk about what happened in the first episode of the show!",8 ,4 ,5, 3, 3, 'cbinne23@apache.org');
