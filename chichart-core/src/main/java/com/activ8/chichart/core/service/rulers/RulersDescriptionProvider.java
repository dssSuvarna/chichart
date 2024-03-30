package com.activ8.chichart.core.service.rulers;

import java.util.*;

class RulersDescriptionProvider {
    private static Map<Ruler, String> descriptions = new HashMap<>();

    static {
        descriptions.put(Ruler.FOUNDATION, "This day is good for putting forward proposals of any type whether for business or love. If you’ve been wanting to renovate or build, are seeking health solutions, thinking of starting a journey, or enrolling in a new course of study, then today is also excellent. Great for applying for, or starting a new job, travelling for business, or any business dealings.");
        descriptions.put(Ruler.NULLIFY, "Use today to commence new habits. Ideal for cleansing on a physical, emotional or spiritual level and for reassessing relationships. Replace the old with the new, do a round of yoga and break up stagnant energy.");
        descriptions.put(Ruler.ABUNDANT, "The actions you undertake today will deliver maximum benefit. Your efforts will be rewarded, or you may find youself seeking opportunities. Today is also good for gatherings of any description, signing agreements of all types and \"official\" openings, or product launches.");
        descriptions.put(Ruler.BALANCE, "A great day to achieve a win-win for all parties involved. Combine more than one part to make a greater whole; like weddings, initiating business plans, or commencing a building or construction project.");
        descriptions.put(Ruler.STABILITY, "If you undertake plans or activities that are long-term, the chance for success will be greatest when commenced today. Ideal for health treatments, a wedding or commitment ceremony, officially sealing an agreement, hiring an employee, or starting activities that will have long-lasting effects, like opening a business.");
        descriptions.put(Ruler.INITIATE, "Today is great for starting any activity that involves new beginnings. Good for new projects, journeys, or accepting a job. Negotiate a better deal, deliver a motivational talk, sign agreements, teach, or sign up for a new course. If moving house, choose an Abundant, Balance, Stability, or Success day for more benefit.");
        descriptions.put(Ruler.CESSATION, "This is a good day for leisure, looking after your health and for closing out, or bringing something to an end. Ideal for demolishing a building, or terminating contracts. Creativity will require extra effort today.");
        descriptions.put(Ruler.UNPREDICTABLE, "A good day for low-risk activities. Keep a cool head and maintain composure. To achieve a positive outcome, extra focus and determination will be required if you’re looking for a specific answer, or relying on others.");
        descriptions.put(Ruler.SUCCESS, "Positive and creative undertakings are likely to result in a satisfying outcome. Today is also a good day for activities relating to promotion, or wealth creation.");
        descriptions.put(Ruler.RECEIVE, "Gain respect for your efforts and gather rewards. A 'Receive' day is ideal for opening a business, launching a product, graduating from school, closing a deal, asking for a raise, proposing to a loved one, or accepting a promotion.");
        descriptions.put(Ruler.ACCESSIBLE, "Open yourself to others today. Welcome visitors to your home, or business. Perfect for official openings of new, or established businesses (eg. after refurbishing or rebranding), house-warming, starting a new job, returning to work, or school after a holiday, or negotiating and signing agreements.");
        descriptions.put(Ruler.INSIGHTFUL, "Today is a good day for solitude and introspection before planning your next move. Perfect for embarking on a holiday/vacation, or to meditate, relax and clear your mind. It is advisable to undertake small, less arduous tasks and conserve your energy.");
    }

    public String getDescription(Ruler ruler) {
        return descriptions.get(ruler);
    }
}
