package serdar.oz.coinkeeper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.adapters.CoinsAdapter;
import serdar.oz.coinkeeper.models.coin.Datum;


public class CoinsActionFragment extends Fragment {
    private Unbinder unbinder;
    ArrayList<Datum> datum = new ArrayList<>();
    @BindView(R.id.rvCoins)
    RecyclerView rvCoins;
    CoinsAdapter coinsAdapter;

    public CoinsActionFragment() {
        // Required empty public constructor
    }

    public static CoinsActionFragment newInstance() {
        CoinsActionFragment fragment = new CoinsActionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coins_action, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getCoins();
    }


    private void getCoins() {
        datum = MainFragment.datum;
        rvCoins.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCoins.setHasFixedSize(true);
        coinsAdapter = new CoinsAdapter(datum, getActivity(), false);
        rvCoins.setAdapter(coinsAdapter);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }


}
