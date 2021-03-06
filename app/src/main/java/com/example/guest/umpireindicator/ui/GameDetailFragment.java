package com.example.guest.umpireindicator.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.umpireindicator.R;
import com.example.guest.umpireindicator.models.Game;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameDetailFragment extends Fragment {
    @Bind(R.id.awayTeamScore) TextView mAwayTeamTextView;
    @Bind(R.id.homeTeamScore) TextView mHomeTeamScore;
    @Bind(R.id.timeStamp) TextView mTimeStamp;
    @Bind(R.id.inningText) TextView mInningText;
    private Game mGame;

    public static GameDetailFragment newInstance(Game game){
        GameDetailFragment gameDetailFragment = new GameDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("game", Parcels.wrap(game));
        gameDetailFragment.setArguments(args);
        return gameDetailFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mGame = Parcels.unwrap(getArguments().getParcelable("game"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_game_detail, container, false);
        ButterKnife.bind(this, view);

        mAwayTeamTextView.setText(mGame.getAway().toUpperCase()+" " + mGame.getAwayTeamScore());
        mHomeTeamScore.setText(mGame.getHome().toUpperCase()+" " + mGame.getHomeTeamScore());
        mTimeStamp.setText("Saved on : " + mGame.getTimeStamp());
        mInningText.setText(mGame.getInningFormat());

        return view;
    }
}
