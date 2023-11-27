create table IF NOT EXISTS chats
(
    chat_id BIGINT PRIMARY KEY,
    author  VARCHAR(30)
);

create table IF NOT EXISTS recipes
(
    recipe_id  BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50),
    image       VARCHAR(255),
    description VARCHAR(255),
    category    VARCHAR(20),
    frequency   BIGINT DEFAULT 0,

    chat_id     BIGINT,
    CONSTRAINT FK_CHAT FOREIGN KEY (chat_id) REFERENCES chats (chat_id)

);

insert into chats (chat_id, author)
VALUES (1, 'Valentina Ivanova'),
       (2,'Roman Rogozin'),
       (3, 'Natalia Mor');
insert into recipes (name, image, description, category, chat_id)
VALUES ('cake','url.image', '1 egg, 2 tablespoons flour, 1 spoon cocoa, 3 chocolate slices', 'dessert', 1),
       ('borsch','url.image', 'cabbage, beets, eggs, onions, beef', 'soup',2),
       ('summer','url.image', 'tomatoes, cucumbers, oil', 'salad',3);