import React, { useState, useEffect } from "react";
import axios from "axios";

function FakePostList() {

  const [posts, setPosts] = useState([]);
  const [filter, setFilter] = useState("");
  const [loading, setLoading] = useState(false);

  const fetchPosts = () => {

    setLoading(true);

    axios.get("https://dummyjson.com/posts")
      .then((response) => {
        setPosts(response.data.posts);
        setLoading(false);
      })
      .catch(() => {
        setLoading(false);
      });

  };

  useEffect(() => {
    fetchPosts();
  }, []);

  const refreshHandler = () => {
    setFilter("");
    fetchPosts();
  };

  const filteredPosts = filter
    ? posts.filter((post) => post.userId === parseInt(filter))
    : posts;

  return (
    <div>

      <h2>Fake API Posts</h2>

      <button onClick={refreshHandler}>Refresh</button>

      <br /><br />

      <label>Filter by User:</label>

      <select
        value={filter}
        onChange={(e) => setFilter(e.target.value)}
      >
        <option value="">All Users</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
        <option value="4">User 4</option>
        <option value="5">User 5</option>
      </select>

      {loading && <p>Loading posts...</p>}

      <ul>

        {filteredPosts.length === 0 && !loading ? (
          <p>No posts found for this user.</p>
        ) : (
          filteredPosts.map((post) => (
            <li key={post.id}>
              <b>{post.title}</b>
              <p>{post.body}</p>
            </li>
          ))
        )}

      </ul>

    </div>
  );
}

export default FakePostList;