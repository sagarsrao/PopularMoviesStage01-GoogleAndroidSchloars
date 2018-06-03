package stageonepopmovies.udacity.com.popularmoviesstageone.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.PopularMovieResponse;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants;

public class PopMovieAdapter extends RecyclerView.Adapter<PopMovieAdapter.ItemHolder> {

    private List<PopularMovieResponse> movieResponseList = new ArrayList<>();
    Context mcontext;

    public PopMovieAdapter(List<PopularMovieResponse> movieResponses, Context context) {
        movieResponses = movieResponseList;
        context = mcontext;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);


        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {


        /*bind the view fro the list*/
        String movieImageUrl = MovieConstants.MOVIE_IMAGE_URL.concat(movieResponseList.get(position).getResults().get(6).getPosterPath());

        Picasso.get().load(movieImageUrl).centerCrop().into(holder.movieView);


    }

    @Override
    public int getItemCount() {
        return movieResponseList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView movieView;

        public ItemHolder(View itemView) {
            super(itemView);
            movieView = (ImageView) itemView.findViewById(R.id.iv_movies);
        }
    }
}